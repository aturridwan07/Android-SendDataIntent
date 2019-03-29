package com.geeksfarm.tugas1intentbiodata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AfterRegistrationActivity extends AppCompatActivity {
    TextView txtNama, txtEmail, txtPass, txtJK, txtTempatLahir, txtTanggalLahir, txtAlamat;
    private Intent intent;
    private String nama, email, pass, lahir, jk, tanggalLahir, alamat;
    Bundle data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_registration);

        txtNama = (TextView) findViewById(R.id.txtNama);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPass = (TextView) findViewById(R.id.txtPass);
        txtJK = (TextView) findViewById(R.id.txtJK);
        txtTempatLahir = (TextView) findViewById(R.id.txtTempatLahir);
        txtTanggalLahir = (TextView) findViewById(R.id.txtTanggalLahir);
        txtAlamat = (TextView) findViewById(R.id.txtAlamat);

        intent = getIntent();

        data = intent.getExtras();
        nama = data.getString("nama");
        email = data.getString("email");
        pass = data.getString("pass");
        lahir=data.getString("lahir");
        tanggalLahir = data.getString("tanggalLahir");
        jk=data.getString("jk");
        alamat=data.getString("alamat");

        txtNama.setText(nama);
        txtEmail.setText(email);
        txtPass.setText(pass);
        txtJK.setText(jk);
        txtTempatLahir.setText(lahir);
        txtTanggalLahir.setText(tanggalLahir);
        txtAlamat.setText(alamat);


    }
}
