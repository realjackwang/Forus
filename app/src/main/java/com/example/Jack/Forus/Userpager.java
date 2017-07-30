//package com.example.Jack.Forus;
//
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.app.Activity;
//import android.os.Handler;
//import android.os.Message;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import cn.bmob.v3.BmobUser;
//import cn.bmob.v3.exception.BmobException;
//import cn.bmob.v3.listener.SaveListener;
//
//public class Userpager extends Activity {
//
//    EditText username;
//    EditText password;
//    private static int FINISH=1;
//    ProgressDialog progressDialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_userpager);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        findViews();
//    }
//
//    private void findViews() {
//        username=(EditText) findViewById(R.id.username);
//        password=(EditText) findViewById(R.id.userpassword);
//        progressDialog=new ProgressDialog(this);
//        progressDialog.setTitle("信息提示");
//        progressDialog.setMessage("正在加载中，请稍后...");
//        progressDialog.setCancelable(true);
//    }
//
//    public void register(View v){
//        Intent i=new Intent(Userpager.this,UserRegister.class);
//        startActivity(i);
//    }
//
//    public void login(View view){
//        new Thread(new HandThread()).start();//开启子线程
//        progressDialog.show();//打开进度加载
//    }
//
//    //设置一下actionBar返回事件
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId()==android.R.id.home){
//            finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what==FINISH){
//                final String name=username.getText().toString();
//                String psd=password.getText().toString();
//                final BmobUser user=new BmobUser();
//                user.setUsername(name);
//                user.setPassword(psd);
//                user.login(new SaveListener() {
//                    @Override
//                    public void done(Object o, BmobException e) {
//                        if(e==null){
//                            if (user.getUsername().equals(name)){
//                                Toast.makeText(Userpager.this, "登陆成功", Toast.LENGTH_SHORT).show();
//                                Intent intent=new Intent(Userpager.this,MainActivity.class);
//                                intent.putExtra("user_name",name);
//                                startActivity(intent);
//                                progressDialog.dismiss();//结束进度加载
//                            }else {
//                                Toast.makeText(Userpager.this, "账号未验证(⊙﹏⊙)", Toast.LENGTH_SHORT).show();
//                                progressDialog.dismiss();//结束进度加载
//                            }
//                        }
//
//                        else{
//                            AlertDialog.Builder builder = new AlertDialog.Builder(Userpager.this,AlertDialog.THEME_HOLO_DARK);
//                            builder.setTitle("信息提示");
//                            builder.setIcon(R.drawable.add);
//                            builder.setMessage("账号或密码输入错误！");
//                            builder.setPositiveButton("确定",null);
//                            builder.show();
//                            progressDialog.dismiss();//结束进度加载
//
//                        }
//                    }
//                });
//            }
//        }
//    };
//
//    private class HandThread implements Runnable {
//        @Override
//        public void run() {
//            Message msg=Message.obtain();
//            msg.what=FINISH;
//            try {
//                Thread.sleep(1000);//缓冲1s
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            handler.sendMessage(msg);//发送并处理
//        }
//    }
//}
