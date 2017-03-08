package com.nov.openview.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yangzhicong on 2017/2/24.
 */

public class ToastUtil {
    /**
     * 土司显示
     *
     * @param context 上下文
     * @param content 土司内容
     */
    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();

    }
}
