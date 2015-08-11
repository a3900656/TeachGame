package com.personal.ken.teachgame;

import com.personal.ken.teachgame.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class GameActivity extends Activity {
    private Button infobutton;
    private Button searchbutton;
    private Button gamebutton;
    private Button teachfobutton;
    private Button moreinfobutton;
    private Button exitbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        infobutton = (Button) findViewById(R.id.button1);
        searchbutton = (Button) findViewById(R.id.button2);
        gamebutton = (Button) findViewById(R.id.button3);
        teachfobutton = (Button) findViewById(R.id.button4);
        moreinfobutton = (Button) findViewById(R.id.button5);
        exitbutton = (Button) findViewById(R.id.button6);

    }
    public void exitOnClick(View v){
        finish();
    }
    public void teachOnClick(View v){
        Intent intent = new Intent();
        intent.setClass(GameActivity.this, TeachActivity.class);
        startActivity(intent);
    }
    public void checkOnClick(View v){
        Intent intent = new Intent();
        intent.setClass(GameActivity.this, CheckActivity.class);
        startActivity(intent);
    }
    public void gameOnClick(View v){
        Intent intent = new Intent();
        intent.setClass(GameActivity.this, YNGameActivity.class);
        startActivity(intent);
    }
    public void personalInfoOnClick(View v){
        Intent intent = new Intent();
        intent.setClass(GameActivity.this, PersonalInfoActivity.class);
        startActivity(intent);
    }
}
