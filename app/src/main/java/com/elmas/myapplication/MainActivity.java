package com.elmas.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText editTextPhone,editTextPhone2,editTextPhone3,editTextPhone4,editTextPhone5,cihazno;
    Button btnSent;
    Button btnUyari;
    Button btnyardim;

    String message1 = new String();
    String message2 = new String();
    String message3 = new String();
    String message4 = new String();
    String message5 = new String();
    String cihaz = new String();
    int flag1=0,flag2=0,flag3=0,flag4=0,flag5=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnUyari=findViewById(R.id.btn_uyari);
        btnyardim=findViewById(R.id.yardim);
        cihazno=findViewById(R.id.cihazno);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextPhone2=findViewById(R.id.editTextPhone2);
        editTextPhone3=findViewById(R.id.editTextPhone3);
        editTextPhone4=findViewById(R.id.editTextPhone4);
        editTextPhone5=findViewById(R.id.editTextPhone5);
        btnSent=findViewById(R.id.button);


        btnyardim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://wa.me/+905326234426?text=Sulama sistemi için yardım istiyorum.";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        AlertDialog.Builder uyariPenceresi= new AlertDialog.Builder(MainActivity.this);
        uyariPenceresi.setTitle("Çıkış");
        uyariPenceresi.setMessage("Çıkmak istiyor musunuz?");
        uyariPenceresi.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
                System.exit(0);
            }
        });
        uyariPenceresi.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Devam Ediyorsunuz",Toast.LENGTH_LONG).show();
            }
        });

        btnUyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uyariPenceresi.show();
            }
        });


        btnSent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Numaralar gönderiliyor.Lütfen bekleyiniz", Toast.LENGTH_LONG).show();

                 message1 = editTextPhone.getText().toString();
                 message2 = editTextPhone2.getText().toString();
                 message3 = editTextPhone3.getText().toString();
                 message4 = editTextPhone4.getText().toString();
                 message5 = editTextPhone5.getText().toString();
                 cihaz = cihazno.getText().toString();



                String kod1= new String();
                String kod2= new String();
                String kod3= new String();
                String kod4= new String();
                String kod5= new String();

                kod1="DkrY1";
                if(!message1.isEmpty()) {
                    message1 = kod1.concat(message1);
                    message1 = message1 + "1234";
                }

                kod2="DkrY2";
                if(!message2.isEmpty()) {
                    message2 = kod2.concat(message2);
                    message2 = message2 + "1234";
                }

                kod3="DkrY3";
                if(!message3.isEmpty()) {
                    message3 = kod3.concat(message3);
                    message3 = message3 + "1234";
                }

                kod4="DkrY4";
                if(!message4.isEmpty()) {
                    message4 = kod4.concat(message4);
                    message4 = message4 + "1234";
                }

                kod5="DkrY5";
                if(!message5.isEmpty()) {
                    message5 = kod5.concat(message5);
                    message5 = message5 + "1234";
                }

                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED){
                    sendSMS();
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},
                            100);
                }

            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            flag1 = 0;flag2=0;flag3=0;flag4=0;flag5=0;
            sendSMS();
        }else{
            Toast.makeText(this, "İzin reddedildi.", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendSMS() {


        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!message1.isEmpty() && !cihaz.isEmpty()){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(cihaz,null,message1,null,null);
                            Toast.makeText(MainActivity.this,"Sms 1 başarıyla gönderildi.", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Lütfen telefon no 1 girin.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 12500);

            }
        });



        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!message2.isEmpty() && !cihaz.isEmpty()){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(cihaz,null,message2,null,null);
                            Toast.makeText(MainActivity.this,"Sms 2 başarıyla gönderildi.", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Lütfen telefon no 2 girin.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 25000);

            }
        });



        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!message3.isEmpty() && !cihaz.isEmpty()){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(cihaz,null,message3,null,null);
                            Toast.makeText(MainActivity.this,"Sms 3 başarıyla gönderildi.", Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(MainActivity.this,"Lütfen telefon no 3 girin.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 37500);

            }
        });



        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!message4.isEmpty() && !cihaz.isEmpty()){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(cihaz,null,message4,null,null);
                            Toast.makeText(MainActivity.this,"Sms 4 başarıyla gönderildi.", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Lütfen telefon no 4 girin.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 45000);

            }
        });


        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!message5.isEmpty() && !cihaz.isEmpty()){
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(cihaz,null,message5,null,null);
                            Toast.makeText(MainActivity.this,"Sms 5 başarıyla gönderildi.", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Lütfen telefon no 5 girin.", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 57500);

            }
        });

    }
}