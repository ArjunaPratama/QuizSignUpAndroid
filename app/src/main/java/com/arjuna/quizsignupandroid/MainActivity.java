package com.arjuna.quizsignupandroid;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etname, etUsername, etalamat, etemail, etPassword, ettempat;
    Spinner spSex, spJob;
    String sex;
    String job;
    String item;
    DatePicker dateBorn;
    String [] datasex = new String[]{
             "L", "P", "None"
    };
    String [] datajob = new String[]{
            "Pelajar", "Mahasiswa", "Guru", "Pekerja"
    };
    Button btnSubmit, btnExit;
    Context context = this;
    TextView ethasil, txtgender;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.etname);
        txtgender = (TextView) findViewById(R.id.txtgender);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etemail = (EditText) findViewById(R.id.etemail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etalamat = (EditText) findViewById(R.id.etalamat);
        ethasil = (TextView) findViewById(R.id.ethasil);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        dateBorn = (DatePicker) findViewById(R.id.dateBorn);
        spJob = (Spinner) findViewById(R.id.spJob);
        spSex = (Spinner) findViewById(R.id.spSex);
        ettempat = (EditText) findViewById(R.id.ettempat);


        spSex = (Spinner) findViewById(R.id.spSex) ;
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datasex);

        spSex.setAdapter(adapter);
        spSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sex = adapterView.getItemAtPosition(i).toString();

                if (sex == "None"){
                    final Dialog dialog = new Dialog(context);
                    //memanggil layout custom
                    dialog.setContentView(R.layout.layout_costum);
                    //mengatur title
                    dialog.setTitle("Warning!");

                    //memanggil button ok
                    //dialog.findviewbyid ini maksdnya adalah memanggil id yang ada di layout custom
                    Button btnOK = (Button)dialog.findViewById(R.id.btnOk);
                    btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //ketika di pencet OK maka alert dialog nya hilang
                            dialog.dismiss();

//                        Intent a1 = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(a1);
                        }
                    });

                    //menampilkan dialog nya
                    dialog.show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {



            }
        });

        spJob = (Spinner) findViewById(R.id.spJob);
        final ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datajob);

        spJob.setAdapter(adapterr);

        spJob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                job = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Warning!");
                alertDialog.setMessage("Apakah anda akan keluar dari aplikasi ini ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //kondisi ketika kita pencet yes
                                MainActivity.this.finish();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });

                AlertDialog alert = alertDialog.create();
                alert.show();

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Warning!");
                alertDialog.setMessage("Apakah anda Yakin?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //kondisi ketika kita pencet yes
                                String nName = etname.getText().toString();
                                String nemail = etemail.getText().toString();
                                String nuser = etUsername.getText().toString();
                                String nalamat = etalamat.getText().toString();
                                String npassword = etPassword.getText().toString();
                                String ntempat = ettempat.getText().toString();
                                String ngender = txtgender.getText().toString();

                                if (nName.isEmpty()) {
                                    //memberikan warning berupa eror
                                    etname.setError("Nama tidak Boleh Kosong");
                                } else if (nuser.isEmpty()) {
                                    //Kondisi ketika lebarnya kosong
                                    etUsername.setError("Username Tidak Boleh Kosong");
                                } else if (nemail.isEmpty()) {
                                    //Kondisi ketika lebarnya kosong
                                    etemail.setError("Email Tidak Boleh Kosong");
                                } else if (npassword.isEmpty()) {
                                    //Kondisi ketika lebarnya kosong
                                    etPassword.setError("Password Tidak Boleh Kosong");
                                } else if (nalamat.isEmpty()) {
                                    //Kondisi ketika lebarnya kosong
                                    etalamat.setError("Username Tidak Boleh Kosong");
                                } else if (ntempat.isEmpty()) {
                                    //Kondisi ketika lebarnya kosong
                                    etalamat.setError("Username Tidak Boleh Kosong");
                                } else {
                                    ethasil.setText("Nama: " + nName +
                                            "\nUsername: " + nuser
                                            + "\nEmail:" + nemail
                                            + "Password: " + npassword
                                            + "\nAlamat:" + nalamat
                                            + "\nJob:" + job
                                            + "\nBirth Of Place:" + ntempat
                                            + "\nDate of Birth:"  + dateBorn.getDayOfMonth() +dateBorn.getMonth() + dateBorn.getYear());
                                    if (sex == "L"){
                                        txtgender.setText("Laki Laki");
                                    }else if (sex == "P"){
                                        txtgender.setText("Perempuan");
                                    }
                                }


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                            }
                        });

                AlertDialog alert = alertDialog.create();
                alert.show();

            }


        });
    }
}
