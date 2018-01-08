package com.ecommerce.bitirme.ecommerce.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ecommerce.bitirme.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class katagoriactivity extends AppCompatActivity {
    List<katagori> categories = new ArrayList<katagori>();
    String username, useremail, userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katagoriactivity);
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        useremail = extras.getString("useremail");
        userid = extras.getString("usersid");
        /* mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/
        categories.add(new katagori("Ev", "", "", "", "", "", ""));
        categories.add(new katagori("Araba", "", "", "", "", "", ""));
        categories.add(new katagori("Spor", "", "", "", "", "", ""));
        categories.add(new katagori("Teknoloji", "", "", "", "", "", ""));
        categories.add(new katagori("Taşıtlar", "", "", "", "", "", ""));
        final ListView liste = (ListView) findViewById(R.id.liste);
        adapter adapterr = new adapter(this, categories);
        liste.setAdapter(adapterr);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                  if(i==0){
                      Intent gecHouseEkle = new Intent(katagoriactivity.this, AddAdvertHouse.class);

                      gecHouseEkle.putExtra("username", username);
                      gecHouseEkle.putExtra("useremail", useremail);
                      gecHouseEkle.putExtra("usersid", userid);
                      startActivity(gecHouseEkle);

                }
                else if(i==1){
                      Intent gecCarEkle = new Intent(katagoriactivity.this, AddAdvertCar.class);

                      gecCarEkle.putExtra("username", username);
                      gecCarEkle.putExtra("useremail", useremail);
                      gecCarEkle.putExtra("usersid", userid);

                      startActivity(gecCarEkle);
                }
                  else if(i==2){
                      //   s="Spor İlanı";
                  }
                  else if(i==3){
                      Intent gecTelefonEkle = new Intent(katagoriactivity.this, AddAdvertTelephoneActivity.class);

                      gecTelefonEkle.putExtra("username", username);
                      gecTelefonEkle.putExtra("useremail", useremail);
                      gecTelefonEkle.putExtra("usersid", userid);

                      startActivity(gecTelefonEkle);
                  }
                //else s="Taşıt ilanı";
             /*  s = categories.get(i).getKatagoriName();
                 gec.putExtra("session", s);
                 startActivity(gec);*/
            }
        });
    }
}
