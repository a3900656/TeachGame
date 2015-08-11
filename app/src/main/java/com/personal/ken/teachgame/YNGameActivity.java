package com.personal.ken.teachgame;

import com.personal.ken.teachgame.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class YNGameActivity extends Activity {
    private Button YesButton;
    private Button NoButton;
    private ImageView questionImage;
    private TextView CorrectNumberText;

    private int[] QuestionImgeID = {R.drawable.teach_1,R.drawable.teach_2};
    private int[] answer = {0,1};

    private int QuestionCounter = 0;
    private int QuestionNumber = 2;

    private Context mContext;
    private int CorrectNumber=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_yngame);

        mContext = this.getApplicationContext();
        questionImage = (ImageView)findViewById(R.id.qimageView);
        YesButton = (Button)findViewById(R.id.yesbutton);
        NoButton = (Button)findViewById(R.id.nobutton);
        CorrectNumberText = (TextView)findViewById(R.id.CorrectNumbertextView);

        QuestionCounter = (int)(Math.random()*QuestionNumber);

        questionImage.setImageResource(QuestionImgeID[QuestionCounter]);

        //Toast.makeText(mContext,String.valueOf(QuestionCounter),Toast.LENGTH_SHORT).show();
    }
    public void YesOnCLick(View v){

        if(answer[QuestionCounter] == 0){
            Toast.makeText(mContext,"答對",Toast.LENGTH_SHORT).show();
            CorrectNumber++;
            CorrectNumberText.setText("答對題數:"+String.valueOf(CorrectNumber));
        }
        else{
            Toast.makeText(mContext,"答錯！！！",Toast.LENGTH_SHORT).show();
        }
        QuestionCounter = (int)(Math.random()*QuestionNumber);
        questionImage.setImageResource(QuestionImgeID[QuestionCounter]);
    }
    public void NoOnCLick(View v){
        if(answer[QuestionCounter] == 1){
            Toast.makeText(mContext,"答對",Toast.LENGTH_SHORT).show();
            CorrectNumber++;
            CorrectNumberText.setText("答對題數:"+String.valueOf(CorrectNumber));
        }
        else{
            Toast.makeText(mContext,"答錯！！！",Toast.LENGTH_SHORT).show();
        }
        QuestionCounter = (int)(Math.random()*QuestionNumber);
        questionImage.setImageResource(QuestionImgeID[QuestionCounter]);
    }
}
