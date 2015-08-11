package com.personal.ken.teachgame;

import com.personal.ken.teachgame.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class CheckActivity extends Activity {
    private Spinner ageSpinner;
    private EditText heightEditText;
    private EditText weightEditText;
    private Spinner genderSpinner;
    private Button checkButton;

    private String[] ageString = {"7","8","9","10","11","12"};
    private String[] genderString = {"男生","女生"};

    private ArrayAdapter<String> ageList;
    private ArrayAdapter<String> genderList;
    private Context mContext;

    private double[][] boyBMI={
            {14.7,18.6,21.2},
            {15.0,19.3,22.0},
            {15.2,19.7,22.5},
            {15.4,20.3,22.9},
            {15.8,21.0,23.5},
            {16.4,21.5,24.2}
    };
    private double[][] girlBMI={
            {14.4,18.0,20.3},
            {14.6,18.8,21.0},
            {14.9,19.3,21.6},
            {15.2,20.1,22.3},
            {15.8,20.9,23.1},
            {16.4,21.6,23.9}
    };

    public int age;
    public int gender;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_check);

        mContext = this.getApplicationContext();
        ageSpinner = (Spinner)findViewById(R.id.spinner);
        heightEditText = (EditText)findViewById(R.id.editText2);
        weightEditText = (EditText)findViewById(R.id.editText3);
        genderSpinner = (Spinner)findViewById(R.id.spinner2);
        checkButton = (Button)findViewById(R.id.checkbutton);

        ageList = new ArrayAdapter<String>(CheckActivity.this,android.R.layout.simple_spinner_item,ageString);
        ageSpinner.setAdapter(ageList);
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                age = position;
                //Toast.makeText(mContext,Double.toString(boyBMI[position][0]), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        genderList = new ArrayAdapter<String>(CheckActivity.this,android.R.layout.simple_spinner_item,genderString);
        genderSpinner.setAdapter(genderList);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
                gender = position;
                //1 = female 0=male
                //Toast.makeText(mContext,Double.toString(boyBMI[position][0]), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
    public void checkButtonOnClick(View v){
        try{
            float hieght = Float.parseFloat(heightEditText.getText().toString())/100;
            float weight = Float.parseFloat(weightEditText.getText().toString());
            float BMI = weight/(hieght*hieght);
            if (gender == 0){
                if (BMI<boyBMI[age][0]){//過瘦
                    Toast.makeText(mContext,"男孩太瘦啦～"+BMI, Toast.LENGTH_SHORT).show();
                }
                else if (BMI<=boyBMI[age][1] && BMI>=boyBMI[age][0]){//正常
                    Toast.makeText(mContext,"男孩正常啦"+BMI, Toast.LENGTH_SHORT).show();
                }
                else if(BMI<boyBMI[age][2] && BMI>=boyBMI[age][1]){//過重
                    Toast.makeText(mContext,"男孩過重啦"+BMI, Toast.LENGTH_SHORT).show();
                }
                else if(BMI>boyBMI[age][2]){//肥胖
                    Toast.makeText(mContext,"太胖啦！男孩該減肥摟"+BMI, Toast.LENGTH_SHORT).show();
                }
            }
            else {
                if (BMI<girlBMI[age][0]){//過瘦
                    Toast.makeText(mContext,"女孩太瘦啦～"+BMI, Toast.LENGTH_SHORT).show();
                }
                else if (BMI<=girlBMI[age][1] && BMI>=boyBMI[age][0]){//正常
                    Toast.makeText(mContext,"女孩正常啦"+BMI, Toast.LENGTH_SHORT).show();
                }
                else if(BMI<girlBMI[age][2] && BMI>=boyBMI[age][1]){//過重
                    Toast.makeText(mContext,"女孩過重啦"+BMI, Toast.LENGTH_SHORT).show();
                }
                else if(BMI>girlBMI[age][2]){//肥胖
                    Toast.makeText(mContext,"太胖啦！女孩該減肥摟"+BMI, Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception e){
            Toast.makeText(mContext,"格式錯誤", Toast.LENGTH_SHORT).show();
        }
    }
}
