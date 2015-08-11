package com.personal.ken.teachgame;

import com.personal.ken.teachgame.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class PersonalInfoActivity extends Activity {
    private ImageView personalpic;
    private int PHOTO = 99;
    private int CAMERA = 100;
    String RECORD_FILE_PATH = "";
    private String photoPath = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_personal_info);
        personalpic = (ImageView)findViewById(R.id.IV_AddPhoto);
    }
    public void personalpicOnClick(View v){
        Intent intent = new Intent( Intent.ACTION_PICK );
        intent.setType("image/*");
        Intent destIntent = Intent.createChooser( intent, "選擇圖片" );
        startActivityForResult( destIntent, PHOTO );
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        if (resultCode != RESULT_OK) { //此處的 RESULT_OK 是系統自定義得一個常量
            Log.e("TAG->onresult", "ActivityResult resultCode error");
            return;
        }
        Bitmap bm = null;
    }
}
