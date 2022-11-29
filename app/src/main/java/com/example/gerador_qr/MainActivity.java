package com.example.gerador_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
  ImageView ivCodigoqr;
  EditText etDatos;
  Button btnGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCodigoqr=findViewById(R.id.ivCodigoqr);
        etDatos=findViewById(R.id.etDatos);
        btnGenerar=findViewById(R.id.btnGenerar);
        //qrImage=findViewById(R.id.qrPlaceHolder);

        btnGenerar.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                try{
                    BarcodeEncoder barcodeEncoder= new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(
                            etDatos.getText().toString(),
                            BarcodeFormat.QR_CODE,
                            750,
                            750
                    );
                    ivCodigoqr.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

    });

    }
}