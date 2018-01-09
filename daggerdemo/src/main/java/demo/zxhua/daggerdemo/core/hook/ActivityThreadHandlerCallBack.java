package demo.zxhua.daggerdemo.core.hook;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Zxhua on 2018/1/3 0003.
 */

public class ActivityThreadHandlerCallBack implements Handler.Callback {

    Handler mBase;

    public ActivityThreadHandlerCallBack(Handler base){
        mBase = base;

    }
    @Override
    public boolean handleMessage(Message message) {
        int what = message.what;

        switch (what){
            case 100:
                break;
        }
        return false;
    }
}
