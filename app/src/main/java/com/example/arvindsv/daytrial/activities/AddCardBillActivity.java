package com.example.arvindsv.daytrial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import com.example.arvindsv.daytrial.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddCardBillActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card_bill);
    }

    protected void onStart(){
        super.onStart();
        displayDateAndSetGlobalBillDate(AddCashBillActivity.DAY_BOOK_CALENDAR);
    }

    private void displayDateAndSetGlobalBillDate(Calendar cal){
        Button fieldVariable = (Button) findViewById(R.id.date);
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd,yyyy");
        fieldVariable.setText(format.format(cal.getTime()));

//       new DatePickerWithReset(getActivity(),android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
//           @Override
//           public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//           }
//       }, year,month, day);

    }

    public void navigateToCashBill(View view){
        Intent intent = new Intent(this, AddCashBillActivity.class);
        startActivity(intent);
    }
}
