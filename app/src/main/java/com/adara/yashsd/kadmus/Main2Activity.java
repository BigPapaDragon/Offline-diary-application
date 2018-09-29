package com.adara.yashsd.kadmus;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Boolean isComplete = false;
    ListView lv;
    FloatingActionButton fab1,fab2,fab3,fab4,fab5,fab6;
    Animation anim1,anim2,anim3,anim4;
    Boolean isOpen = false;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dataBase = new DataBase(this);

        fab1 = (FloatingActionButton)findViewById(R.id.fabOne);
        fab2 = (FloatingActionButton)findViewById(R.id.fabTwo);
        fab3 = (FloatingActionButton)findViewById(R.id.fabThree);
        fab4 = (FloatingActionButton)findViewById(R.id.fabFour);
        fab5 = (FloatingActionButton)findViewById(R.id.fabFive);
        fab6 = (FloatingActionButton)findViewById(R.id.fabSix);

        fab2.setVisibility(View.INVISIBLE);
        fab2.setClickable(false);
        fab3.setVisibility(View.INVISIBLE);
        fab3.setClickable(false);
        fab4.setVisibility(View.INVISIBLE);
        fab4.setClickable(false);
        fab5.setVisibility(View.INVISIBLE);
        fab5.setClickable(false);
        fab6.setVisibility(View.INVISIBLE);
        fab6.setClickable(false);

        anim1 = AnimationUtils.loadAnimation(this,R.anim.button_open);
        anim2 = AnimationUtils.loadAnimation(this,R.anim.button_close);
        anim3 = AnimationUtils.loadAnimation(this,R.anim.rotate_open);
        anim4 = AnimationUtils.loadAnimation(this,R.anim.rotate_close);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isOpen == false)
                {
                    fab1.startAnimation(anim3);

                    fab2.startAnimation(anim1);
                    fab3.startAnimation(anim1);
                    fab4.startAnimation(anim1);
                    fab5.startAnimation(anim1);
                    fab6.startAnimation(anim1);

                    fab2.setClickable(true);
                    fab3.setClickable(true);
                    fab4.setClickable(true);
                    fab5.setClickable(true);
                    fab6.setClickable(true);
                    isOpen = true;
                }
                else if(isOpen == true)
                {
                    fab1.startAnimation(anim4);

                    fab2.startAnimation(anim2);
                    fab3.startAnimation(anim2);
                    fab4.startAnimation(anim2);
                    fab5.startAnimation(anim2);
                    fab6.startAnimation(anim2);

                    fab2.setClickable(false);
                    fab3.setClickable(false);
                    fab4.setClickable(false);
                    fab5.setClickable(false);
                    fab6.setClickable(false);

                    isOpen = false;
                }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });

        lv = (ListView)findViewById(R.id.lv);
        try{
            FileInputStream fis = openFileInput(FileNameConstants.PNFS);
            String temp= "";
            int c;
            while((c = fis.read())!=-1)
            {
                temp = temp + Character.toString((char)c);
            }
            if(temp.equals("1")){
                isComplete = true;
            }
            else {
                isComplete = false;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<String> namesForArray= dataBase.NamesForArray();
        String[] namesforarray = new String[namesForArray.size()];
        namesforarray = namesForArray.toArray(namesforarray);

        List<String> idForArray= dataBase.IdForArray();
        String[] idforarray = new String[idForArray.size()];
        idforarray = idForArray.toArray(idforarray);

        List<String> timestampForArray= dataBase.TimestampForArray();
        String[] timestampforarray = new String[timestampForArray.size()];
        timestampforarray = timestampForArray.toArray(timestampforarray);

        List<String> bodyForArray= dataBase.BodyForArray();
        String[] bodyforarray = new String[bodyForArray.size()];
        bodyforarray = bodyForArray.toArray(bodyforarray);

        List<String> typeForArray= dataBase.TypeForArray();
        String[] typeforarray = new String[typeForArray.size()];
        typeforarray = typeForArray.toArray(typeforarray);

        List<String> authorForArray= dataBase.AuthorForArray();
        String[] authorforarray = new String[authorForArray.size()];
        authorforarray = authorForArray.toArray(authorforarray);

        List<String> hashtag1ForArray= dataBase.Hashtag1ForArray();
        String[] hashtag1forarray = new String[hashtag1ForArray.size()];
        hashtag1forarray = hashtag1ForArray.toArray(hashtag1forarray);

        List<String> hashtag2ForArray= dataBase.Hashtag2ForArray();
        String[] hashtag2forarray = new String[hashtag2ForArray.size()];
        hashtag2forarray = hashtag2ForArray.toArray(hashtag2forarray);

        List<String> hashtag3ForArray= dataBase.Hashtag3ForArray();
        String[] hashtag3forarray = new String[hashtag3ForArray.size()];
        hashtag3forarray = hashtag3ForArray.toArray(hashtag3forarray);

        List<String> hashtag4ForArray= dataBase.Hashtag4ForArray();
        String[] hashtag4forarray = new String[hashtag4ForArray.size()];
        hashtag4forarray = hashtag4ForArray.toArray(hashtag4forarray);

        List<String> hashtag5ForArray= dataBase.Hashtag5ForArray();
        String[] hashtag5forarray = new String[hashtag5ForArray.size()];
        hashtag5forarray = hashtag5ForArray.toArray(hashtag5forarray);

        List<String> hashtag6ForArray= dataBase.Hashtag6ForArray();
        String[] hashtag6forarray = new String[hashtag6ForArray.size()];
        hashtag6forarray = hashtag6ForArray.toArray(hashtag6forarray);

        List<String> hashtag7ForArray= dataBase.Hashtag7ForArray();
        String[] hashtag7forarray = new String[hashtag7ForArray.size()];
        hashtag7forarray = hashtag7ForArray.toArray(hashtag7forarray);

        List<String> hashtag8ForArray= dataBase.Hashtag8ForArray();
        String[] hashtag8forarray = new String[hashtag8ForArray.size()];
        hashtag8forarray = hashtag8ForArray.toArray(hashtag8forarray);

        List<String> hashtag9ForArray= dataBase.Hashtag9ForArray();
        String[] hashtag9forarray = new String[hashtag9ForArray.size()];
        hashtag9forarray = hashtag9ForArray.toArray(hashtag9forarray);

        List<String> hashtag10ForArray= dataBase.Hashtag10ForArray();
        String[] hashtag10forarray = new String[hashtag10ForArray.size()];
        hashtag10forarray = hashtag10ForArray.toArray(hashtag10forarray);

        customadapt ca = new customadapt(this,idforarray,namesforarray,authorforarray,timestampforarray,typeforarray,
                bodyforarray,hashtag1forarray,hashtag2forarray,hashtag3forarray,hashtag4forarray,hashtag5forarray,hashtag6forarray,
                hashtag7forarray,hashtag8forarray,hashtag9forarray,hashtag10forarray);
        lv.setAdapter(ca);
    }
}
