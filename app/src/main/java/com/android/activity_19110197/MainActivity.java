package com.android.activity_19110197;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtSoTienGui, edtLaiSuatGui, edtKyHanGui;
    Button btnXemKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnXemKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSoTienGui.getText().length() ==0 || edtLaiSuatGui.getText().length() ==0
                        || edtKyHanGui.getText().length() ==0 ) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                    ;
                }
                else {
                    Intent intent=new Intent(MainActivity.this, KetQuaActivity.class);
                    Bundle bundle=new Bundle();
                    double sotiengui =Double.parseDouble(edtSoTienGui.getText().toString().trim());
                    double laisuat =Double.parseDouble(edtLaiSuatGui.getText().toString().trim());
                    double kyhan =Double.parseDouble(edtKyHanGui.getText().toString().trim());
                    bundle.putDouble("sotiengui", sotiengui);
                    bundle.putDouble("laisuat", laisuat);
                    bundle.putDouble("kyhan", kyhan);
                    intent.putExtra("data", bundle);
                    startActivity(intent);
                }

            }
        });
    }

    void AnhXa() {
        edtSoTienGui = (EditText) findViewById(R.id.edtSoTienGui);
        edtLaiSuatGui = (EditText) findViewById(R.id.edtLaiSuatGui);
        edtKyHanGui = (EditText) findViewById(R.id.edtKyHanGui);
        btnXemKetQua = (Button) findViewById(R.id.btnXemKetQua);
    }
}