package com.geeksfarm.tugas1intentbiodata;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private EditText dateView, inNama,inEmail, inPass, inAlamat,inLahir, inTanggalLahir;
    private RadioGroup RgJK;
    private RadioButton RbJK;
    private int year, month, day;
    private Intent intent;
    private String nama, email, pass, lahir, jk, tanggalLahir, alamat;


    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (EditText) findViewById(R.id.inDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        inNama = (EditText) findViewById(R.id.inNama);
        inEmail = (EditText) findViewById(R.id.inEmail);
        inLahir = (EditText) findViewById(R.id.inTempatLahir);
        inPass = (EditText) findViewById(R.id.inPassword);
        inAlamat = (EditText) findViewById(R.id.inAlamat);
        inTanggalLahir = (EditText) findViewById(R.id.inDate);
        RgJK = (RadioGroup) findViewById(R.id.rgJk);
        RbJK = (RadioButton) findViewById(RgJK.getCheckedRadioButtonId());
    }

    public void register(View v){
        nama = inNama.getText().toString();
        email = inEmail.getText().toString();
        pass = inPass.getText().toString();
        lahir = inLahir.getText().toString();
        tanggalLahir = inTanggalLahir.getText().toString();
        jk = RbJK.getText().toString();
        alamat = inAlamat.getText().toString();

        //create object intent
         intent= new Intent(this, AfterRegistrationActivity.class);
        //create bundle
        Bundle data = new Bundle();
        data.putString("nama",nama);
        data.putString("email",email);
        data.putString("pass",pass);
        data.putString("lahir",lahir);
        data.putString("tanggalLahir",tanggalLahir);
        data.putString("jk",jk);
        data.putString("alamat",alamat);
        //put extras
        intent.putExtras(data);
        //start activity
        startActivity(intent);

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        /*Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
                */
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}
