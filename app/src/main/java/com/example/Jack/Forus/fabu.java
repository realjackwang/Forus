package com.example.Jack.Forus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class fabu extends Activity {
    public EditText mName,mFeedback,mchaxun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "bfb519d77e9049fbf4c475c3c55cc49d");
        setContentView(R.layout.fabu);
        mName = (EditText) findViewById(R.id.name);
        mFeedback = (EditText)findViewById(R.id.feedback);
//        mchaxun = (EditText)findViewById(R.id.editText2);


    }
//    public  void chaxun(View view){
//        String str = mchaxun.getText().toString();
//        if(str.equals("")){
//            return;
//        }
//        BmobQuery<Feedback>query = new BmobQuery<>();
//        query.addWhereEqualTo("name",str);
//        query.findObjects(new FindListener<Feedback>() {
//            @Override
//            public void done(List<Feedback> list, BmobException e) {
//                if(e==null){
//                    AlertDialog.Builder builder = new AlertDialog.Builder(fabu.this);
//                    builder.setTitle("查询结果");
//                    String str = "";
//                    for (Feedback feedback : list) {
//                        str += feedback.getName()+":"+feedback.getFeedback()+"\n";
//                    }
//                    builder.setMessage(str);
//                    builder.create().show();
//
//                }
//            }
//        });
//    }
//    public  void queryall(View view){
//        BmobQuery<Feedback>query = new BmobQuery<>();
//        query.findObjects(new FindListener<Feedback>() {
//            @Override
//            public void done(List<Feedback> list, BmobException e) {
//                if(e==null){
//                    ArrayList<String>list1 = new ArrayList<>();
//                    list1.add("通知列表：");
//                    for (Feedback feedback : list) {
//                        list1.add(feedback.getName());
//                    }
//                    ListView listView1 = (ListView) findViewById(R.id.list);
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(fabu.this,R.layout.listitem,list1);
//                    listView1.setAdapter(adapter);
//                    Toast.makeText(fabu.this,"查询成功",Toast.LENGTH_SHORT).show();
//                }
//
//                else{
//                    Toast.makeText(fabu.this,"查询失败",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//
//    }
    public void submit(View view){
        String name = mName.getText().toString();
        String feedback = mFeedback.getText().toString();
        if (name.equals("")||feedback.equals("")){
            Toast.makeText(fabu.this,"输入框为空",Toast.LENGTH_LONG).show();
            return;
        }
        Feedback feedbackObj = new Feedback();
        feedbackObj.setName(name);
        feedbackObj.setFeedback(feedback);
        feedbackObj.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(fabu.this,"提交成功",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(fabu.this,"提交失败",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}