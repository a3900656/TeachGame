package com.personal.ken.teachgame;

import com.personal.ken.teachgame.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class TeachActivity extends Activity {
    private ImageView teachimage;
    private Button nextButton;
    private int[] TeachImgeID = {R.drawable.teach_1,R.drawable.teach_2};
    private int TeachPicCounter = 0,TeachPicNumber = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_teach);
        nextButton =(Button)findViewById(R.id.button);
        teachimage = (ImageView)findViewById(R.id.imageView);
        teachimage.setImageResource(TeachImgeID[TeachPicCounter]);
    }
    public void nextOnClick(View v){
        teachimage.setImageResource(TeachImgeID[(TeachPicCounter+1)%TeachPicNumber]);
        TeachPicCounter=(TeachPicCounter+1)%TeachPicNumber;
    }
    public void LastOnClick(View v){
        if (TeachPicCounter>0) {
            teachimage.setImageResource(TeachImgeID[(TeachPicCounter - 1) % TeachPicNumber]);
            TeachPicCounter = (TeachPicCounter - 1) % TeachPicNumber;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //TeachPicCounter = 0;
    }
}