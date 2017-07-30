//package com.example.Jack.Forus;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import cn.bmob.v3.exception.BmobException;
//import cn.bmob.v3.listener.SaveListener;
//
//public class UserRegister extends Activity {
//
//    EditText username,password,email;
//    private static int FINISH=1;
//    ProgressDialog progressDialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_register);
//        findViews();
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
//    public void register(View view){
//        new Thread(new HandThread()).start();//开启子线程
//        progressDialog.show();//打开进度加载
//
//    }
//
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what==FINISH){
//                //拿到对应输入文本
//                String name = username.getText().toString().trim();
//                String pass = password.getText().toString().trim();
//                String user_email=email.getText().toString().trim();
//                if (name.equals("") || pass.equals("")  || user_email.equals("")){
//                    AlertDialog.Builder builder = new AlertDialog.Builder(UserRegister.this,AlertDialog.THEME_HOLO_DARK);
//                    builder.setTitle("信息提示");
//                    builder.setMessage("用户名或密码,邮箱未填写！");
//                    builder.setIcon(R.drawable.add);
//                    builder.setPositiveButton("返回",null);
//                    builder.show();
//                    return;
//                }
//                User user=new User();
//                user.setName(name);
//                user.setPassword(pass);
//                user.setEmail(user_email);
//                user.signUp(new SaveListener() {
//                    @Override
//                    public void done(Object o, BmobException e) {
//                        if(e==null) {
//                            Toast.makeText(UserRegister.this, "注册成功，赶快去登陆吧！", Toast.LENGTH_SHORT).show();
//                            Intent intent=new Intent(UserRegister.this,Userpager.class);
//                            startActivity(intent);
//                        }
//                        else{
//                            AlertDialog.Builder builder = new AlertDialog.Builder(UserRegister.this,AlertDialog.THEME_HOLO_DARK);
//                            builder.setTitle("信息提示");
//                            builder.setMessage("注册失败，请检查网络！");
//                            builder.setIcon(R.drawable.add);
//                            builder.setPositiveButton("确定",null);
//                            builder.show();
//                        }
//                            }
//
//                });
//            }
//        }
//    };
//
//
//    private class HandThread implements Runnable {
//        @Override
//        public void run() {
//            Message msg=Message.obtain();
//            msg.what=FINISH;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            handler.sendMessage(msg);//发送至handler
//        }
//    }
//
//    //实例化控件
//    private void findViews() {
//        username=(EditText) findViewById(R.id.username);
//        password=(EditText) findViewById(R.id.userpassword);
//        email= (EditText) findViewById(R.id.email);
//        progressDialog=new ProgressDialog(this);
//        progressDialog.setTitle("信息提示");
//        progressDialog.setMessage("正在加载中，请稍后...");
//        progressDialog.setCancelable(true);
//    }
//
//    //返回事件
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId()==android.R.id.home){
//            finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
