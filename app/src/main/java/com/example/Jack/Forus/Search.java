package com.example.Jack.Forus;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class Search extends AppCompatActivity {
    private EditText mchaxun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "bfb519d77e9049fbf4c475c3c55cc49d");
        setContentView(R.layout.activity_search);
        mchaxun = (EditText)findViewById(R.id.editText3);

    }
    public  void chaxun1(View view){
        String str = mchaxun.getText().toString();
        if(str.equals("")){
            return;
        }
        BmobQuery<Feedback> query = new BmobQuery<>();
        query.addWhereEqualTo("name",str);
        query.findObjects(new FindListener<Feedback>() {
            @Override
            public void done(List<Feedback> list, BmobException e) {
                if(e==null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Search.this);
                    builder.setTitle("查询结果");
                    String str = "";
                    for (Feedback feedback : list) {
                        str += "通知名称"+feedback.getName()+"\n"+"通知内容"+feedback.getFeedback()+"\n";
                    }
                    builder.setMessage(str);
                    builder.create().show();

                }
            }
        });
    }
}
