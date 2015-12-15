package com.example.arvindsv.daytrial.activities;

import com.example.arvindsv.daytrial.R;
import com.example.arvindsv.daytrial.dialogs.DatePickerWithReset;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddCashBillActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.example.arvindsv.daytrial.MESSAGE";
    public static Calendar DAY_BOOK_CALENDAR;
//    ActivityStatus objStatus = new ActivityStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cash_bill);
        DAY_BOOK_CALENDAR = Calendar.getInstance();
    }

    protected void onResume(){
        super.onResume();
        displayDateAndSetGlobalBillDate();
    }

    public void displayDateAndSetGlobalBillDate(){
        Button fieldVariable = (Button) findViewById(R.id.date);
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd,yyyy");
        fieldVariable.setText(format.format(DAY_BOOK_CALENDAR.getTime()));
    }

    private void showSetDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        DAY_BOOK_CALENDAR = cal;
        displayDateAndSetGlobalBillDate();
    }

    public void addBill(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText billNumber = (EditText) findViewById(R.id.bill_number);
        EditText billAmount = (EditText) findViewById(R.id.bill_amount);
        String message = " " + billNumber.getText().toString() + " " + billAmount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        billNumber.setText("");
        billAmount.setText("");
        startActivity(intent);
    }

    public void changeDate(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void navigateToCardBill(View view){
        Intent intent = new Intent(this, AddCardBillActivity.class);
        startActivity(intent);
    }

    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            c.setTime(DAY_BOOK_CALENDAR.getTime());
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerWithReset(getActivity(),android.R.style.Theme_Holo_Dialog, this, year,month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            if (year == 0){
                DAY_BOOK_CALENDAR = Calendar.getInstance();
                displayDateAndSetGlobalBillDate();}
            else
                showSetDate(year, month, day);
        }
    }
}
