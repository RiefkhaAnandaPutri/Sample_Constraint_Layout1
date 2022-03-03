package com.example.sample_constraint_layout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //untuk editText
    EditText edemail, edpassword;

    //untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnlogin dengan komponen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan komponen button pada layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan komponen button pada layout
        edpassword = findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnlogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi();
            }
        });
    }

    public void validasi() {
        //Menyimpan input user di edittext email kedalam variabel nama
        nama = edemail.getText().toString();

        //Menyimpan input user di editText password kedalam variabel password
        password = edpassword.getText().toString();
        if (nama.isEmpty() && password.isEmpty()) {
            edemail.setError("Email yang anda masukkan salah");
            edpassword.setError("Password salah");

        } else {
            //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
            Toast t = Toast.makeText(getApplicationContext(),
                    "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);

            //Menampilkan toast
            t.show();
            edemail.getText().clear();
        }
    }
}