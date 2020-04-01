package cn.edu.sdwu.android.classroom.sn170507180117;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class Ch4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //加载界面，不要写文件名，使用资源ID来引用资源
        setContentView(R.layout.layout_ch4_1);
        //1）获取普通界面组件:必须在setContentView之后，调用findViewById方法
        Button button=(Button) findViewById(R.id.button1);
        ImageView imageView= (ImageView) findViewById(R.id.ch4_iv);

        //3)调用事件源的setxxxListener方法注册事件监听器
        button.setOnClickListener(new MyClickListener());
        //
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //设置壁纸
                WallpaperManager wallpaperManager= (WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try {
                    wallpaperManager.setResource(R.raw.img);
                } catch (IOException e) {
                    Log.e(Ch4Activity.class.toString(),e.toString());
                }
                return true;
            }

        });
    }

    //2）实现事件监听类
    class MyClickListener implements View.OnClickListener{

        public void onClick(View view){
            Log.i(Ch4Activity.class.toString(),"button click");
       }
   }
}
