package demo.zxhua.daggerdemo.core.hook;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import demo.zxhua.daggerdemo.App;
import demo.zxhua.daggerdemo.ui.scend.PitSeatActivity;

/**
 * Created by Zxhua on 2018/1/2 0002.
 */

public class HookActivityHandler implements InvocationHandler {

    public static final String TAG = "HookActivityHandler";

    public static final String TARGET = "targetIntent";
    private Object mBase;

    public HookActivityHandler(Object base) {
        this.mBase = base;
    }



    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if ("startActivity".equalsIgnoreCase(method.getName())) {
            Log.d(TAG, "invoke,startActivity");

            Intent rawIntent = null;
            int index = 0;

            for (int i = 0; i < objects.length; i++) {
                if (objects[i] instanceof Intent) {
                    index = i;
                    break;
                }
            }

            rawIntent = (Intent) objects[index];

            Intent pitIntent = new Intent();//坑位 intent

            String targetPackageName = App.get().getPackageName();
            ComponentName componentName = new ComponentName(targetPackageName, PitSeatActivity.class.getName());
            pitIntent.setComponent(componentName);

            pitIntent.putExtra(TARGET, rawIntent);//保存 原Intent
            objects[index] = pitIntent;
        }
        return method.invoke(mBase, objects);
    }

    public static final void hookActivityManagerService(ClassLoader classLoader) {
        try {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");

            if (activityManagerNativeClass == null) return;

            Field gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");

            if (gDefaultField == null) return;

            gDefaultField.setAccessible(true);

            Object gDefault = gDefaultField.get(null);

            @SuppressLint("PrivateApi") Class<?> singleton = Class.forName("android.util.Singleton");

            if (singleton == null) return;

            Field mInstanceField = singleton.getDeclaredField("mInstance");

            mInstanceField.setAccessible(true);

            Object activityManager = mInstanceField.get(gDefault);
            Class<?> activityManagerInterface = Class.forName("android.app.IActivityManager");
            Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{activityManagerInterface}, new HookActivityHandler(activityManager));
            mInstanceField.set(gDefault, proxy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
