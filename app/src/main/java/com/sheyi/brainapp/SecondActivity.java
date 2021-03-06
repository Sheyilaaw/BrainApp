package com.sheyi.brainapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView resultTextView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        imageView = (ImageView)findViewById(R.id.imageView);
        Intent intent = getIntent();
        String score = intent.getStringExtra("Score");
        String questions = intent.getStringExtra("questionsAnswered");
        float ratio = Float.parseFloat(score)/Float.parseFloat(questions);
        System.out.print(ratio);
        if(ratio<0.3){
            imageView.setImageResource(R.drawable.laff_cry);
        }else if(ratio>=0.3 && ratio<=0.6){
            imageView.setImageResource(R.drawable.laff_teeth);
        }else if(Integer.parseInt(score)==0){
            imageView.setImageResource(R.drawable.sad);
        }
        else{
            imageView.setImageResource(R.drawable.images);
        }
        resultTextView.setText("You Scored "+ score + "/" + questions);

    }
    public void goBack(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
