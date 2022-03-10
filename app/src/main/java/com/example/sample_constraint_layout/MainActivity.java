package com.example.sample_constraint_layout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
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
                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di editText password kedalam variabel password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                //mengecek apakah edittext email dan password terapat isi atau tidak
                if (nama.isEmpty() && password.isEmpty()) {
                    //membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                } else {

                    //mengecek apakah isi dari email dan password sudah sama dengan email dan
                    //password yang sudah di riset
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukkn value dari vaiabel nama dengan kunci "a"
                        //dan dimasukkan kedalam bundle
                        b.putString("a", nama.trim());

                        //memasukkan value dari variabel password dengan kunci "b"
                        //dan dimaukkan kedalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membuat toast dan menampilkan pesan "Login gagal"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();
                    }
                    edemail.setError("Email yang anda masukkan salah");
                    edpassword.setError("Password salah");
                }

            //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
            Toast t = Toast.makeText(getApplicationContext(),
                    "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);
            }
        }
    });
