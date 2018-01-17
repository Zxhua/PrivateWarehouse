package code.zxhua.aspectjlib.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Zxhua on 2018/1/9 0009.
 */
@Aspect
public class TraceAspect {

    private static final String Aspect_TAG = "Aspect-zxhua";

    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toLongString();
        Log.d(Aspect_TAG, "onActivityMethodBefore:" + key);
        System.out.println("==========AOP Aspect-zxhua start ============");
    }

}
