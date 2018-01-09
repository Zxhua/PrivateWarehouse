package demo.zxhua.daggerdemo.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import demo.zxhua.daggerdemo.App;

/**
 * Created by Zxhua on 2017/12/26 0026.
 */

public class UiUtil {

    public UiUtil() {
    }

    public static int dp2px(float dpValue) {
        float scale = App.get().getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }

    public static int px2dp(float pxValue) {
        float scale = App.get().getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5F);
    }

    public static int sp2px(float spValue) {
        float fontScale = App.get().getResources().getDisplayMetrics().scaledDensity;
        return (int)(spValue * fontScale + 0.5F);
    }

    public static int px2sp(float pxValue) {
        float fontScale = App.get().getResources().getDisplayMetrics().scaledDensity;
        return (int)(pxValue / fontScale + 0.5F);
    }


    static String REGEX_IDCARD = "(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)";

    public static void main(String[] args) {
        if (checkWithRex("622102200001048316", REGEX_IDCARD)) {
            System.out.println("=========身份证合法");
        } else {
            System.out.println("xxxxxxxxx身份证不合法");

        }
    }

    public static boolean checkWithRex(String str, String rex) {
        if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            Pattern compile = Pattern.compile(rex);
            Matcher matcher = compile.matcher(str);
            return matcher.matches();
        }
    }
}
