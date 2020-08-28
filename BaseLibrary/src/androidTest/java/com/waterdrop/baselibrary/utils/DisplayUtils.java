package com.waterdrop.baselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DisplayUtils {
    // 获取手机屏幕高度
    private String getWidthAndHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels; // 宽
        int height = dm.heightPixels; // 高
        WindowManager mWindowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        width = mWindowManager.getDefaultDisplay().getWidth();
        height = mWindowManager.getDefaultDisplay().getHeight();
        return width + "," + height;
    }

    public static int getHeight(Activity activity) {
        WindowManager mWindowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        //int width = mWindowManager.getDefaultDisplay().getWidth();
        int height = mWindowManager.getDefaultDisplay().getHeight();
        return height;
    }

    public static int getWidth(Activity activity) {
        WindowManager mWindowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        int width = mWindowManager.getDefaultDisplay().getWidth();
        //int height = mWindowManager.getDefaultDisplay().getHeight();
        return width;
    }


}
