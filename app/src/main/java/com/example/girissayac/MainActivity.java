package com.example.girissayac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSayac;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSayac = (TextView) findViewById(R.id.textViewSayac);

        //once sayacı kaydedebilmek için bir tane dosya oluşturabilmem gerekiyor.

        sp = getSharedPreferences("GirisSayac", MODE_PRIVATE); //mode private yapıyorum daha güvenli olması açısından.
        editor = sp.edit();

        //uygulama açıldıgı anda güncel sayacı almam gerekiyor.
        int sayac = sp.getInt("sayac",0);
        editor.putInt("sayac",++sayac);
        editor.commit();  //commit diyerek kayıt işlemini yapıyorum.

        //daha sonra bunu textView'e yazdırıyorum.
        textViewSayac.setText("Sayaç: "+String.valueOf(sayac));

    }
}