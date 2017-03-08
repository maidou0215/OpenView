package com.nov.openview.utils;

import android.app.Activity;
import android.content.Context;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * 时间提示框选择
 * Created by yangzhicong on 2017/2/21.
 */
public class DatePickerDialogView extends DatePickerDialog {

    private static int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private static int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private static int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    public interface onDateSetListener {
        void onDateSetComplete(int year, int month, int day);
    }

    public static void showDialog(Context context, final onDateSetListener listener) {
        Calendar now = Calendar.getInstance();
        now.set(mYear, mMonth, mDay);
        DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                Calendar temp = Calendar.getInstance();
                temp.clear();
                temp.set(year, monthOfYear, dayOfMonth);
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                listener.onDateSetComplete(year, monthOfYear, dayOfMonth);
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

        dialog.setThemeDark(true);
        dialog.setMaxDate(Calendar.getInstance());
        Calendar minDate = Calendar.getInstance();
        minDate.set(2014, 5, 12);
        dialog.setMinDate(minDate);
        // set the dialog not vibrate when date change, default value is true
        dialog.vibrate(false);

        dialog.show(((Activity)context).getFragmentManager(), "DatePickerDialog");
    }
}
