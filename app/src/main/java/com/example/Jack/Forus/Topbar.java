package com.example.Jack.Forus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Topbar extends RelativeLayout {
    private Button leftButton,rightButton,centerButton;
    private TextView tvTitile;

    private int leftTextColor;
    private Drawable leftBackground;
    private  String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private  String rightText;

    private float titleTextSize;
    private  int titleTextColor;
    private  String title;

    private int centerTextColor;
    private Drawable centerBackground;
    private String centerText;

    private LayoutParams leftParams;
    private LayoutParams rightParams;
    private LayoutParams titleParams;
    private LayoutParams centerParams;

    private topbarClickListener listener;

    public interface topbarClickListener{
        public void leftClick();
        public void rightClick();
        public void centerClick();
    }

public  void setOnTopbarClickListener(topbarClickListener listener){
    this.listener = listener;
}
    
    
    public  Topbar(final Context context, AttributeSet attrs){
        super(context,attrs);
        TypedArray ta =context.obtainStyledAttributes(attrs,R.styleable.Topbar);
        leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor,0);
        leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = ta.getString(R.styleable.Topbar_leftText);

        rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = ta.getString(R.styleable.Topbar_rightText);

        centerTextColor = ta.getColor(R.styleable.Topbar_centerTextColor,0);
        centerBackground = ta.getDrawable(R.styleable.Topbar_centerBackground);
        centerText = ta.getString(R.styleable.Topbar_centerText);

        titleTextSize= ta.getDimension(R.styleable.Topbar_titleTextSize,0) ;
        titleTextColor= ta.getColor(R.styleable.Topbar_titleTextColor,0);
        title = ta.getString(R.styleable.Topbar_title);

        ta.recycle();

        leftButton = new Button(context);
        rightButton = new Button(context);
        tvTitile = new TextView(context);
        centerButton = new Button(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        centerButton.setTextColor(centerTextColor);
        centerButton.setBackground(centerBackground);
        centerButton.setText(centerText);

        tvTitile.setTextColor(titleTextColor);
        tvTitile.setTextSize(titleTextSize);
        tvTitile.setText(title);

        setBackgroundColor(Color.parseColor("#03a9f4"));

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        addView(leftButton,leftParams);

        centerParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        centerParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        centerParams.width=500;

        addView(centerButton,centerParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        rightParams.width=110;
        
        addView(rightButton,rightParams);
        

        
        

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);

        addView(tvTitile,titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               listener.leftClick();

            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.rightClick();

            }
        });
        centerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.centerClick();
            }
        });

    }
    public void setLeftButtonIsVisiable(boolean flag){
        if(flag){
            leftButton.setVisibility(View.VISIBLE);
        }else{
            leftButton.setVisibility(View.GONE);
        }
    }
    public void setRightButtonIsVisiable(boolean flag){
        if(flag){
            rightButton.setVisibility(View.VISIBLE);
        }else{
            rightButton.setVisibility(View.GONE);
        }
    }
    public void setCenterButtonIsVisiable(boolean flag){
        if(flag){
            centerButton.setVisibility(View.VISIBLE);
        }else{
            centerButton.setVisibility(View.GONE);
        }
    }
}
