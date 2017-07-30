package com.example.Jack.Forus;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class uesri extends AppCompatActivity {
    private EditText xingming= null;
    private EditText nianling= null;
    private EditText xuexiao = null;
    private EditText xuehao = null;
    private EditText shouji = null;
    private EditText  qq= null;
    private EditText minzu = null;
    private EditText youxiang = null;
    private EditText xueyuan = null;
    private Button save=null;
    private TextView nicheng1=null;
    private int year ;
    private Calendar calendar = null;
    private int day ;
    private EditText nicheng=null;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    private List<String> list = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useri);
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        year = calendar.get(Calendar.YEAR);
        xingming =(EditText)findViewById(R.id.editText1);
        nianling=(EditText)findViewById(R.id.editText2);
        xuexiao = (EditText)findViewById(R.id.editText5);
        xuehao =(EditText)findViewById(R.id.editText7);
        shouji = (EditText)findViewById(R.id.editText4);
        qq= (EditText)findViewById(R.id.editText8);
        minzu = (EditText)findViewById(R.id.editText3);
        youxiang = (EditText)findViewById(R.id.editText9);
        xueyuan =(EditText)findViewById(R.id.editText6);
        save=(Button)findViewById(R.id.button4);
        nicheng=(EditText)findViewById(R.id.editText10) ;
        nicheng1=(TextView)findViewById(R.id.textView) ;

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("test", Context.MODE_WORLD_READABLE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("姓名",xingming.getText().toString());
                editor.putString("年龄",nianling.getText().toString());
                editor.putString("学校",xuexiao.getText().toString());
                editor.putString("手机",shouji.getText().toString());
                editor.putString("QQ",qq.getText().toString());
                editor.putString("民族",minzu.getText().toString());
                editor.putString("邮箱",youxiang.getText().toString());
                editor.putString("学院",xueyuan.getText().toString());
                editor.putString("学号",xuehao.getText().toString());
                editor.putString("昵称",nicheng.getText().toString());
                editor.commit();
                Toast.makeText(uesri.this,"保存成功",Toast.LENGTH_SHORT).show();
            }
        });

    SharedPreferences sharedPreferences =getSharedPreferences("test",Context.MODE_PRIVATE);
        String 姓名=sharedPreferences.getString("姓名","");
        String 昵称=sharedPreferences.getString("昵称","");
        String 年龄=sharedPreferences.getString("年龄","");
        String 学校=sharedPreferences.getString("学校","");
        String 手机=sharedPreferences.getString("手机","");
        String QQ=sharedPreferences.getString("QQ","");
        String 民族=sharedPreferences.getString("民族","");
        String 邮箱=sharedPreferences.getString("邮箱","");
        String 学院=sharedPreferences.getString("学院","");
        String 学号=sharedPreferences.getString("学号","");
        xingming.setText(姓名);
        nianling.setText(年龄);
        xuexiao.setText(学校);
        shouji.setText(手机);
        qq.setText(QQ);
        minzu.setText(民族);
        youxiang.setText(邮箱);
        xueyuan .setText(学院);
        xuehao.setText(学号);
        nicheng.setText(昵称);


        list.add("汉族");
        list.add("蒙古族");
        list.add("回族");
        list.add("藏族");
        list.add("维吾尔族");
        list.add("苗族");
        list.add("彝族");
        list.add("壮族");
        list.add("布依族");
        list.add("朝鲜族");
        list.add("满族");
        list.add("白族");
        list.add("土家族");
        list.add("哈萨克族");
        list.add("傣族");
        list.add("黎族");

        mySpinner = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(new  Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mySpinner.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
});
        mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

    }
    public void useriback(View view){
        Intent intent = new Intent(uesri.this,MainActivity.class);
        startActivity(intent);}
    public void data(View view){
         new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                 setTitle(year + "-" + (monthOfYear+1) + "-" + dayOfMonth);
             }
         }, year, calendar.get(Calendar.MONTH), day).show();
    }
    }


