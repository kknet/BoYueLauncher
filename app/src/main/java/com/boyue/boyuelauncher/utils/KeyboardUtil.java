package com.boyue.boyuelauncher.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class KeyboardUtil {
    /**
     * 隱藏软键盘
     */
    public static void hideSoftInput(Activity mContext) {
        try {
            ((InputMethodManager) mContext
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(mContext.getCurrentFocus()
                                    .getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示软键盘
     */
    public static void showSoftInput(Activity mContext) {
        try {
            ((InputMethodManager) mContext
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
