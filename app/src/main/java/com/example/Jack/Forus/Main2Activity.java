package com.example.Jack.Forus;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UploadFileListener;


public class Main2Activity extends AppCompatActivity {
public String fileurl="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "bfb519d77e9049fbf4c475c3c55cc49d");
        setContentView(R.layout.activity_main2);
        new Thread(new Runnable(){
            ImageView  image=(ImageView)Main2Activity.this.findViewById(R.id.imageView23);
        String urladdress = "content://media/external/images/media/4";
            Drawable drawable = loadImageFromNetwork(urladdress);
            @Override
            public void run(){

                image.post(new Runnable(){
                    @Override
                    public void run(){
                        //TODO Auto-generated method stub
                        image.setImageDrawable(drawable);
                    }
                });
            }
            private Drawable loadImageFromNetwork(String urladdr) {
// TODO Auto-generated method stub
                Drawable drawable = null;
                try{

    drawable = Drawable.createFromStream(new URL(urladdr).openStream(), "image.jpg");
    }catch(IOException e){
    Log.d("test",e.getMessage());
    }
    if(drawable == null){
    Log.d("test","null drawable");
    }else{
     Log.d("test","not null drawable");
    }
 return drawable;
            }
        }).start();
    }




    private String getImagePath(Uri uri) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null,null,null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            }
            cursor.close();

        }
        return path;

    }
public void bbb(View view){
    Uri uri = null;
    String path= getImagePath(uri);
    final BmobFile bmobfile=new BmobFile(new File(path)); {
        bmobfile.upload(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                fileurl = bmobfile.getUrl();
                Toast.makeText(Main2Activity.this,"yeah",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

}