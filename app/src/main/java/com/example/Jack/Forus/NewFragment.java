package com.example.Jack.Forus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NewFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_layout, container, false);
        Topbar topbar2 = (Topbar)view.findViewById(R.id.MyTopbar2);
        topbar2.setLeftButtonIsVisiable(false);//设置topbar按键隐藏
        topbar2.setRightButtonIsVisiable(false);
        topbar2.setCenterButtonIsVisiable(false);
        topbar2.setOnTopbarClickListener( new Topbar.topbarClickListener() {
            public void leftClick() {

            }

            public void rightClick() {

            }

            public void centerClick() {

            }
        }
        );
        return view;
    }



    public static NewFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        NewFragment fragment = new NewFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
