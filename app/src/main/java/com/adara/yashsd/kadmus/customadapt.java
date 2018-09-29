package com.adara.yashsd.kadmus;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


//to add anything else other than strings in the custom view simply extend ArrayAdapter<OBJECT_NAME>
public class customadapt extends ArrayAdapter {

    private Activity context;
    private String[] idArr;
    private String[] nameArr;
    private String[] authorArr;
    private String[] timestampArr;
    private String[] typeArr;
    private String[] bodyArr;
    private String[] hashtag1Arr;
    private String[] hashtag2Arr;
    private String[] hashtag3Arr;
    private String[] hashtag4Arr;
    private String[] hashtag5Arr;
    private String[] hashtag6Arr;
    private String[] hashtag7Arr;
    private String[] hashtag8Arr;
    private String[] hashtag9Arr;
    private String[] hashtag10Arr;


    public customadapt(Activity context, String[] idArr, String[] nameArr,String[] authorArr,String[] timestampArr,String[] typeArr,String[] bodyArr,String[] hashtag1Arr,
                       String[] hashtag2Arr,String[] hashtag3Arr,String[] hashtag4Arr,String[] hashtag5Arr,String[] hashtag6Arr,
                       String[] hashtag7Arr,String[] hashtag8Arr,String[] hashtag9Arr,String[] hashtag10Arr)
    {
        super(context,R.layout.customlayout,idArr);
        this.context = context;
        this.idArr = idArr;
        this.nameArr = nameArr;
        this.authorArr = authorArr;
        this.timestampArr = timestampArr;
        this.typeArr = typeArr;
        this.bodyArr = bodyArr;
        this.hashtag1Arr = hashtag1Arr;
        this.hashtag2Arr = hashtag2Arr;
        this.hashtag3Arr = hashtag3Arr;
        this.hashtag4Arr = hashtag4Arr;
        this.hashtag5Arr = hashtag5Arr;
        this.hashtag6Arr = hashtag6Arr;
        this.hashtag7Arr = hashtag7Arr;
        this.hashtag8Arr = hashtag8Arr;
        this.hashtag9Arr = hashtag9Arr;
        this.hashtag10Arr = hashtag10Arr;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inf = context.getLayoutInflater();
        View rowview = inf.inflate(R.layout.customlayout,null,true);

        TextView[] tvht = new TextView[10];

        tvht[0] = (TextView)rowview.findViewById(R.id.tvht1);
        tvht[1] = (TextView)rowview.findViewById(R.id.tvht2);
        tvht[2] = (TextView)rowview.findViewById(R.id.tvht3);
        tvht[3] = (TextView)rowview.findViewById(R.id.tvht4);
        tvht[4] = (TextView)rowview.findViewById(R.id.tvht5);
        tvht[5] = (TextView)rowview.findViewById(R.id.tvht6);
        tvht[6] = (TextView)rowview.findViewById(R.id.tvht7);
        tvht[7] = (TextView)rowview.findViewById(R.id.tvht8);
        tvht[8] = (TextView)rowview.findViewById(R.id.tvht9);
        tvht[9] = (TextView)rowview.findViewById(R.id.tvht10);

        TextView tvID1 = (TextView)rowview.findViewById(R.id.tvID1);
        TextView tvName2 = (TextView)rowview.findViewById(R.id.tvName2);
        TextView tvTime3 = (TextView)rowview.findViewById(R.id.tvTime3);
        TextView tvAuthor4 = (TextView)rowview.findViewById(R.id.tvAuthor4);
        TextView tvbody5 = (TextView)rowview.findViewById(R.id.tvbody5);
        //ImageView ivca = (ImageView)rowview.findViewById(R.id.ivca);


        /*if(typeArr[position].equals("diary")){
            ivca.setImageDrawable(context.getDrawable(R.drawable.diary_v_two));
        } else if (typeArr[position].equals("dreamjournal")){
            ivca.setImageDrawable(context.getDrawable(R.drawable.dream_journal_v_two));
        } else if (typeArr[position].equals("poems")){
            ivca.setImageDrawable(context.getDrawable(R.drawable.poem_v_two));
        } else if (typeArr[position].equals("notes")){
            ivca.setImageDrawable(context.getDrawable(R.drawable.note_v_two));
        } else if (typeArr[position].equals("")) {
            ivca.setVisibility(View.INVISIBLE);
        }*/

        tvID1.setText(idArr[position]);
        tvName2.setText(nameArr[position]);
        tvTime3.setText(timestampArr[position]);
        tvAuthor4.setText(authorArr[position]);
        tvbody5.setText(bodyArr[position]);

        /*if(hashtag1Arr[position].equals("") || hashtag1Arr[position].equals(null) || hashtag1Arr[position] == null){
            tvht[0].setVisibility(View.INVISIBLE);
        }else{
            tvht[0].setText(hashtag1Arr[position]);
        }*/

        if(hashtag2Arr[position].equals("") || hashtag2Arr[position].equals(null) || hashtag2Arr[position] == null){
            tvht[1].setVisibility(View.INVISIBLE);
        }else{
            tvht[1].setText(hashtag2Arr[position]);
        }

        if(hashtag3Arr[position].equals("") || hashtag3Arr[position].equals(null) || hashtag3Arr[position] == null){
            tvht[2].setVisibility(View.INVISIBLE);
        }else{
            tvht[2].setText(hashtag3Arr[position]);
        }

        if(hashtag4Arr[position].equals("") || hashtag4Arr[position].equals(null) || hashtag4Arr[position] == null){
            tvht[3].setVisibility(View.INVISIBLE);
        }else{
            tvht[3].setText(hashtag4Arr[position]);
        }

        if(hashtag5Arr[position].equals("") || hashtag5Arr[position].equals(null) || hashtag5Arr[position] == null){
            tvht[4].setVisibility(View.INVISIBLE);
        }else{
            tvht[4].setText(hashtag5Arr[position]);
        }

        if(hashtag6Arr[position].equals("") || hashtag6Arr[position].equals(null) || hashtag6Arr[position] == null){
            tvht[5].setVisibility(View.INVISIBLE);
        }else{
            tvht[5].setText(hashtag6Arr[position]);
        }

        if(hashtag7Arr[position].equals("") || hashtag7Arr[position].equals(null) || hashtag7Arr[position] == null){
            tvht[6].setVisibility(View.INVISIBLE);
        }else{
            tvht[6].setText(hashtag7Arr[position]);
        }

        if(hashtag8Arr[position].equals("") || hashtag8Arr[position].equals(null) || hashtag8Arr[position] == null){
            tvht[7].setVisibility(View.INVISIBLE);
        }else{
            tvht[7].setText(hashtag8Arr[position]);
        }

        if(hashtag9Arr[position].equals("") || hashtag9Arr[position].equals(null) || hashtag9Arr[position] == null){
            tvht[8].setVisibility(View.INVISIBLE);
        }else{
            tvht[8].setText(hashtag9Arr[position]);
        }

        if(hashtag10Arr[position].equals("") || hashtag10Arr[position].equals(null) || hashtag10Arr[position] == null){
            tvht[9].setVisibility(View.INVISIBLE);
        }else{
            tvht[9].setText(hashtag10Arr[position]);
        }
        return rowview;
    }
}
