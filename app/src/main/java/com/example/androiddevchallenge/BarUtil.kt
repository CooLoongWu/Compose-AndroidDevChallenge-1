package com.example.androiddevchallenge

import android.app.Activity
import android.graphics.Color
import android.view.WindowManager
import android.os.Build
import android.view.View

/**
 * 顶部栏工具类
 *
 * @author Created by gold on 2018/7/17 15:27
 */
object BarUtil {
    /**
     * 设置顶部状态栏透明
     *
     * @param activity activity
     */
    fun execStatusBarTranslucent(activity: Activity) {
        val window = activity.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }

        //解决 状态栏变色的bug
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                try {
//                    Class decorViewClazz = Class.forName("com.android.internal.policy.DecorView");
//                    Field field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor");
//                    field.setAccessible(true);
//                    field.setInt(activity.getWindow().getDecorView(), Color.TRANSPARENT);  //去掉高版本蒙层改为透明
//                } catch (Exception e) {
//                }
//            }
//        }
    }
}