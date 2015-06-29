package com.example.lxxself.calculator;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/6/27.
 */
public class Utils {

    public static int getAppTheme(Context context){
        String value = SharedPreferrenceHelper.gettheme(context);
        switch (Integer.valueOf(value)){
            case 1:
                return R.style.Theme_AppCompat_Light_NoActionBar;
            case 2:
                return R.style.Theme_AppCompat_NoActionBar;
            default:
                return R.style.Theme_AppCompat_Light_NoActionBar;
        }
    }
    public static void switchAppTheme(Context context){
        String value = SharedPreferrenceHelper.gettheme(context);
        switch (Integer.valueOf(value)){
            case 1:
                SharedPreferrenceHelper.settheme(context,"2");
                break;
            case 2:
                SharedPreferrenceHelper.settheme(context,"1");
                break;
            default:
                SharedPreferrenceHelper.settheme(context,"1");
                break;
        }
    }

}
