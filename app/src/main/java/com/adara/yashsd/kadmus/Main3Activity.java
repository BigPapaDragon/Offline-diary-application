package com.adara.yashsd.kadmus;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {

    EditText et2,etMainBody;

    TextView tv5,tv6,tv7;
    TextView tvht[] = new TextView[10];

    FloatingActionButton fab7;
    Button bht;

    private String hashTag = "";
    int hashtagcount  = 0 ;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dataBase = new DataBase(this);

        fab7 = (FloatingActionButton) findViewById(R.id.fabSeven);
        fab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataBase.insertdata(et2.getText().toString(),"test",
                        tv5.getText().toString()+"/"+tv6.getText().toString()+"/"+tv7.getText().toString(),
                        "diary",etMainBody.getText().toString(), tvht[0].getText().toString(),tvht[1].getText().toString(),
                        tvht[2].getText().toString(),tvht[3].getText().toString(), tvht[4].getText().toString(),tvht[5].getText().toString(),
                        tvht[6].getText().toString(),tvht[7].getText().toString(),
                        tvht[8].getText().toString(),tvht[9].getText().toString());

                Toast.makeText(Main3Activity.this, "Saved !", Toast.LENGTH_SHORT).show();
            }
        });

        bht = (Button)findViewById(R.id.bht);
        bht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hashtagcount<8){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                    builder.setTitle("Hashtag :");

                    // Set up the input
                    final EditText input = new EditText(Main3Activity.this);

                    // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    builder.setView(input);

                    // Set up the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            hashTag = input.getText().toString();
                            for(int i=0;i<10;i++){
                                String temp = tvht[i].getText().toString();
                                if(temp.equals("")){
                                    tvht[i].setText("#"+hashTag);
                                    tvht[i].setVisibility(View.VISIBLE);
                                    tvht[i].setClickable(true);
                                    break;
                                }
                            }
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                } else{
                    Toast.makeText(Main3Activity.this, "Maximum number of hashtag reached!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        et2 = (EditText)findViewById(R.id.et2);
        etMainBody = (EditText)findViewById(R.id.etmainbody);

        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        tv7 = (TextView)findViewById(R.id.tv7);

        tvht[0] = (TextView)findViewById(R.id.tvht1);
        tvht[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[0]);
            }
        });
        tvht[1] = (TextView)findViewById(R.id.tvht2);
        tvht[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[1]);
            }
        });
        tvht[2] = (TextView)findViewById(R.id.tvht3);
        tvht[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[2]);
            }
        });
        tvht[3] = (TextView)findViewById(R.id.tvht4);
        tvht[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[3]);
            }
        });
        tvht[4] = (TextView)findViewById(R.id.tvht5);
        tvht[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[4]);
            }
        });
        tvht[5] = (TextView)findViewById(R.id.tvht6);
        tvht[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[5]);
            }
        });
        tvht[6] = (TextView)findViewById(R.id.tvht7);
        tvht[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[6]);
            }
        });
        tvht[7] = (TextView)findViewById(R.id.tvht8);
        tvht[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[7]);
            }
        });
        tvht[8] = (TextView)findViewById(R.id.tvht9);
        tvht[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[8]);
            }
        });
        tvht[9] = (TextView)findViewById(R.id.tvht10);
        tvht[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeHashTag(tvht[9]);
            }
        });

        /*Date c = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd"+"\n"+"MMM"+"\n"+"yyyy");
        String formattedDate = simpleDateFormat.format(c);
        tv5.setText(formattedDate);*/

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("YYYY");

        String stringDate = simpleDateFormat1.format(c);
        String stringMonth = simpleDateFormat2.format(c);
        String stringYear = simpleDateFormat3.format(c);

        tv5.setText(stringDate);
        tv6.setText(stringMonth);
        tv7.setText(stringYear);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkHashtag();
    }

    public void checkHashtag(){
        for(int i=0;i<10;i++){
            String temp = tvht[i].getText().toString();
            if(temp.equals("")){
                tvht[i].setVisibility(View.INVISIBLE);
                tvht[i].setClickable(false);
            }
        }
    }

    public void changeHashTag(TextView tvht){
        final TextView tvhtf = tvht;
        AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
        builder.setTitle("Hashtag :");

        // Set up the input
        final EditText input = new EditText(Main3Activity.this);
        input.setText(tvht.getText().toString());

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hashTag = input.getText().toString();
                tvhtf.setText(hashTag);
                checkHashtag();
            }
        });
        builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvhtf.setText("");
                checkHashtag();
                dialog.cancel();
            }
        });
        builder.show();
    }
}
