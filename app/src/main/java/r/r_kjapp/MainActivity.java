/*
* This source code was created by RioKosuga.
*/

package r.r_kjapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static r.r_kjapp.R.drawable.yellow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ホスト画面へ画面遷移
        Button host_button = (Button) findViewById(R.id.host_button);
        host_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(), HostActivity.class);
                startActivity(intent);
            }
        });
    }


    // メモカラー変更
    public void setScreenYellow(View v){
        ((ImageView) findViewById(R.id.image1)).setImageResource(R.drawable.yellow);
    }
    public void setScreenBlue(View v){
        ((ImageView) findViewById(R.id.image1)).setImageResource(R.drawable.blue);
    }
    public void setScreenPink(View v){
        ((ImageView) findViewById(R.id.image1)).setImageResource(R.drawable.pink);
    }
    public void setScreenGreen(View v){
        ((ImageView) findViewById(R.id.image1)).setImageResource(R.drawable.green);
    }
}
