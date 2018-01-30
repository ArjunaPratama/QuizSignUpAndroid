package com.arjuna.quizsignupandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityHasil extends AppCompatActivity {

    TextView etNama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        etNama = (TextView) findViewById(R.id.txtNama);

        Intent a1 = getIntent();
        //mengambil data yang sudah di put sbelum nya dengan variable yang nama
        String ambilUser = a1.getStringExtra("user");
        String ambilNama = a1.getStringExtra("nama");
        String ambilEmail = a1.getStringExtra("email");
        String ambilPass = a1.getStringExtra("pass");
        String ambilJob = a1.getStringExtra("job");
        String ambilAlamat = a1.getStringExtra("alamat");
        String ambilGen = a1.getStringExtra("gen");
        String ambilTempat = a1.getStringExtra("tempat");


        etNama.setText("Hy, " + ambilNama
                +"\n Username :" + ambilUser
                + "\n Email :" + ambilEmail
                +"\n Password :" + ambilPass
                +"\n Job :" + ambilJob
                +"\n Alamat :" + ambilAlamat
                +"\n Gender :" + ambilGen
                +"\n Tempat:" + ambilTempat);
    }
}
