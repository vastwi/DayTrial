package com.example.arvindsv.daytrial.dialogs;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.example.arvindsv.daytrial.R;


public class DatePickerWithReset extends DatePickerDialog {
    private  OnDateSetListener mDateSetListener;
    private Context themeContext;

    public DatePickerWithReset(Context context, int theme, OnDateSetListener callBack,
                                int year, int monthOfYear, int dayOfMonth) {
        super(context, theme, callBack, year, monthOfYear, dayOfMonth);

        mDateSetListener = callBack;

        themeContext = getContext();
        setButton(BUTTON_POSITIVE,
                themeContext.getText(R.string.datePicker_setButton), this);
        setButton(BUTTON_NEUTRAL,
                themeContext.getText(R.string.datePicker_resetButton), this);
        setButton(BUTTON_NEGATIVE,
                themeContext.getText(R.string.datePicker_cancelButton), this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case BUTTON_NEUTRAL:
                mDateSetListener.onDateSet(super.getDatePicker(), 0, 0, 0);
                break;
            default:
                super.onClick(dialog,which);
                break;
        }
    }
}
