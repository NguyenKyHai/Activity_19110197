package com.android.activity_19110197;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KetQuaActivity extends AppCompatActivity {
    TextView txtlainhan,txttiennhan;
    Button btnPicture;
    int REQUEST_CODE_CAMERA=1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        txtlainhan=(TextView) findViewById(R.id.txtLaiNhanDuoc);
        txttiennhan=(TextView) findViewById(R.id.txtTienNhan);
        btnPicture=(Button)findViewById(R.id.btnPicture);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("data");
        //String chuoi=bundle.getString("chuoi");
        double sotiengui =bundle.getDouble("sotiengui");
        double laisuat =bundle.getDouble("laisuat");
        double kyhan =bundle.getDouble("kyhan");
        double lainhan=sotiengui*laisuat/100*kyhan*30/360;
        double tiennhan=sotiengui+lainhan;
        txtlainhan.setText(lainhan + "đ");
        txttiennhan.setText(tiennhan + "đ");

        btnPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1,REQUEST_CODE_CAMERA);

            }
        });

    }
}