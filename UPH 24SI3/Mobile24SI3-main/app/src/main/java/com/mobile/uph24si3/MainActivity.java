package com.mobile.uph24si3;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etAngka1, etAngka2;
    TextView tvHasil;
    Button btnTambah, btnKurang, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka1 = findViewById(R.id.etAngka1);
        etAngka2 = findViewById(R.id.etAngka2);
        tvHasil = findViewById(R.id.tvHasil);

        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);

        btnTambah.setOnClickListener(v -> hitung("+"));
        btnKurang.setOnClickListener(v -> hitung("-"));
        btnKali.setOnClickListener(v -> hitung("*"));
        btnBagi.setOnClickListener(v -> hitung("/"));
    }

    private void hitung(String op) {
        String a = etAngka1.getText().toString();
        String b = etAngka2.getText().toString();

        if (a.isEmpty() || b.isEmpty()) {
            Toast.makeText(this, "Input tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        double angka1 = Double.parseDouble(a);
        double angka2 = Double.parseDouble(b);
        double hasil = 0;

        switch (op) {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                if (angka2 == 0) {
                    Toast.makeText(this, "Tidak bisa bagi 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                hasil = angka1 / angka2;
                break;
        }

        tvHasil.setText("Hasil: " + hasil);
    }
}