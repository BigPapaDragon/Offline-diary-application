package com.adara.yashsd.kadmus;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView iv1;
    TextView tv1,tv2;
    EditText et1;
    Button b1,b2;
    CheckBox cb1;

    Boolean isSuccess1 = false;
    Boolean isSuccess2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = (ImageView)findViewById(R.id.iv1);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        et1 = (EditText)findViewById(R.id.et1);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        cb1 = (CheckBox)findViewById(R.id.cb1);

        iv1.setAlpha(0.0f);
        tv1.setAlpha(0.0f);
        tv2.setAlpha(0.0f);
        et1.setAlpha(0.0f);
        b1.setAlpha(0.0f);
        b2.setAlpha(0.0f);
        cb1.setAlpha(0.0f);

        final ObjectAnimator objAni1 = ObjectAnimator.ofFloat(iv1, View.ALPHA,0.0f,1.0f);
        final ObjectAnimator objAni2 = ObjectAnimator.ofFloat(tv1,View.ALPHA,0.0f,1.0f);
        final ObjectAnimator objAni3 = ObjectAnimator.ofFloat(tv2,View.ALPHA,0.0f,1.0f);
        final ObjectAnimator objAni4 = ObjectAnimator.ofFloat(et1,View.ALPHA,0.0f,1.0f);
        final ObjectAnimator objAni5 = ObjectAnimator.ofFloat(b1,View.ALPHA,0.0f,1.0f);
        final ObjectAnimator objAni6 = ObjectAnimator.ofFloat(b2,View.ALPHA,0.0f,1.0f);
        final ObjectAnimator objAni7 = ObjectAnimator.ofFloat(cb1,View.ALPHA,0.0f,1.0f);

        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playSequentially(objAni2,objAni1,objAni3,objAni4,objAni5,objAni6,objAni7);
        aniSet.start();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream fos = openFileOutput(FileNameConstants.PNF,MODE_PRIVATE);
                    fos.write(et1.getText().toString().getBytes());
                    fos.close();
                    isSuccess1 = true;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                try{
                    FileOutputStream fos = openFileOutput(FileNameConstants.PNFS,MODE_PRIVATE);
                    fos.write("1".getBytes());
                    fos.close();
                    isSuccess2 = true;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                if(isSuccess1 == true || isSuccess2 == true) {
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }

                setResult(001);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    FileOutputStream fos = openFileOutput(FileNameConstants.PNF,MODE_PRIVATE);
                    fos.write("-----".getBytes());
                    fos.close();
                    isSuccess1 = true;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

                if(cb1.isChecked())
                {
                    try{
                        FileOutputStream fos = openFileOutput(FileNameConstants.PNFS,MODE_PRIVATE);
                        fos.write("1".getBytes());
                        fos.close();
                        isSuccess2 = true;
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        FileOutputStream fos = openFileOutput(FileNameConstants.PNFS, MODE_PRIVATE);
                        fos.write("0".getBytes());
                        fos.close();
                        isSuccess2 = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if(isSuccess1 == true || isSuccess2 == true) {
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }
                setResult(001);
                finish();
            }
        });
    }

}
