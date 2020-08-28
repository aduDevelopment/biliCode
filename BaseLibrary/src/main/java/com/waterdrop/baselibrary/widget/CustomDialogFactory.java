package com.waterdrop.baselibrary.widget;

import android.app.Dialog;
import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.dyhdyh.widget.loadingbar2.factory.LoadingFactory;
import com.waterdrop.baselibrary.R;
import com.waterdrop.baselibrary.utils.DisplayUtils;

public class CustomDialogFactory implements LoadingFactory<Context, Dialog> {
    /**
     * 工厂类的标识符
     * 在cancel()之前多次调用show()时，当key相同时不会重新调用onCreate
     *
     * @return
     */
    @Override
    public String getKey() {
        return getClass().getName();
    }

    @Override
    public Dialog onCreate(Context params) {
        //这里return的dialog就是Loading的样式
        Dialog dialog = new AlertDialog.Builder(params)
                .setView(R.layout.loading_dialog)
                .setCancelable(false)
                .create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(DisplayUtils.dpToPx(params,60), DisplayUtils.dpToPx(params,60));
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        return dialog;
    }

    @Override
    public void updateStatus(Object[] extras) {
        //每次调用show会回调这里  还有携带的参数
    }
}