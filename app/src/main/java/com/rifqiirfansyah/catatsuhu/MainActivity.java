package com.rifqiirfansyah.catatsuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSuhu, editTextnis;
    Button button1, button2;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTimeDisplay = (TextView)findViewById(R.id.hari);
        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        date = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date());
        dateTimeDisplay.setText(date);

        editTextnis = (EditText) findViewById(R.id.editTextNis);
        editTextSuhu = (EditText) findViewById(R.id.editTextSuhu);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nis = editTextnis.getText().toString().trim();
                final String suhu = editTextSuhu.getText().toString().trim();

                if (suhu.equals("") || (nis.equals(""))){
                    Toast.makeText(MainActivity.this, "Data Tidak Boleh Kosong",
                            Toast.LENGTH_LONG).show();
                }
                else {


                    class AddSuhu extends AsyncTask<Void, Void, String> {

                        ProgressDialog loading;

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            loading = ProgressDialog.show(MainActivity.this,
                                    "Menambahkan...", "Tunggu...", false, false);
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            loading.dismiss();
                            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        protected String doInBackground(Void... v) {
                            HashMap<String, String> params = new HashMap<>();
                            params.put(Konfigurasi.KEY_NIS, nis);
                            params.put(Konfigurasi.KEY_SUHU, suhu);


                            RequestHandler rh = new RequestHandler();
                            String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                            return res;
                        }
                    }

                    AddSuhu ae = new AddSuhu();
                    ae.execute();
                }
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LihatDataSuhu.class));
                finish();
            }
        });

    }
}

