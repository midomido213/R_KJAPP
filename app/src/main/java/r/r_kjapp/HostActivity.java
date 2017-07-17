/*
* This source code was created by RioKosuga.
*/

package r.r_kjapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static r.r_kjapp.R.id.imageView;

public class HostActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener{

    // 変数いろいろ宣言
//    private FrameLayout frameLayout01;
    private ConstraintLayout constraintlayout;
    private ImageView target;
    private Button trash;
    private int targetLocalX;
    private int targetLocalY;
    private int screenX;
    private int screenY;

    // 画像拡大縮小の変数
    private static final int STATE_NON = 0;         // 無操作
    private static final int STATE_DRAGING = 2;     // 移動操作
    private static final int STATE_ZOOMING = 4;     // 拡大縮小操作中
    private static final int STATE_ROTATING = 5;    // 回転捜査中

    private static final int STATE_WAITING = 1;     // ユーザーの操作待ち　シングルタッチ？ダブルタッチ？
    private static final int STATE_CHECKING = 3;    // ユーザーの操作待ち　拡大縮小？回転？


    private static final int CHECK_TIMEOUT
            = ViewConfiguration.getTapTimeout() + ViewConfiguration.getLongPressTimeout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        constraintlayout = (ConstraintLayout) findViewById(R.id.ConstraintLayout);

        target = (ImageView)findViewById(imageView);
        target.setOnTouchListener(this);

        trash = (Button)findViewById(R.id.trash);
        trash.setOnClickListener(this);

        // 画面遷移
        Button guest_button = (Button)findViewById(R.id.guest_button);
        guest_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

//        // 画像の拡大・縮小
//        imageView = (ImageView)findViewById(R.id.imageView);
//
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pink);
//        int imageWidth = bitmap1.getWidth();
//        int imageHeight = bitmap1.getHeight();
//
//        // Matrix インスタンス生成
//        Matrix matrix = new Matrix();
//
//        // 1/2の縮小率
//        float ratio = 0.5f;
//
//        Bitmap bitmap3 = Bitmap.createBitmap(bitmap1, 0, 0, imageWidth, imageHeight, matrix, true);
//
//        // drawableに変換
//        Drawable drawable = new BitmapDrawable(getResources(), bitmap3);
//
//        target.setImageDrawable(drawable);

//        ZoomImageView zoomImageView = new ZoomImageView(this);
//        zoomImageView.setImageResourceId(R.drawable.yellow);
//        // もしくは setImageBitmap(bitmap);
//        zoomImageView.setMaxScale(1.5F);    // 省略可(デフォルト:2F)
//        zoomImageView.setMinScale(0.1F);    // 省略可(デフォルト:0.5F)
//        zoomImageView.setDoubleTapDuration(200);    // 省略可(デフォルト:300)

    }

    // 背景変更
    public void setBackWhite(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.white);
    }
    public void setBack1(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.back1);
    }
    public void setBack2(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.back2);
    }
    public void setBack3(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.back3);
    }
    public void setBack4(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.back4);
    }
    public void setBack5(View v){
        ((ImageView) findViewById(R.id.back)).setImageResource(R.drawable.back5);
    }


    // ImageViewを指で動かす
    // グルーピング機能部分
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x = (int)event.getRawX();
        int y = (int)event.getRawY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                targetLocalX = target.getLeft();
                targetLocalY = target.getTop();

                screenX = x;
                screenY = y;

                break;

            case MotionEvent.ACTION_MOVE:

                int diffX = screenX - x;
                int diffY = screenY - y;

                targetLocalX -= diffX;
                targetLocalY -= diffY;

                target.layout(targetLocalX,
                        targetLocalY,
                        targetLocalX + target.getWidth(),
                        targetLocalY + target.getHeight());

                screenX = x;
                screenY = y;

                break;

        }
        return true;
    }
    @Override
    public void onClick(View v) {
        int childCount = constraintlayout.getChildCount();
        if(childCount == 1) {
            constraintlayout.addView(target);
        }
    }

}
