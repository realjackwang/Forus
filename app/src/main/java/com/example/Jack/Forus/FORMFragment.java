package com.example.Jack.Forus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class FORMFragment extends Fragment {
    private FragmentActivity mContext;
    private Button bu;
    private ImageButton bu2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form, container, false);
        Topbar topbar = (Topbar) view.findViewById(R.id.MyTopbar);
        topbar.setOnTopbarClickListener(new Topbar.topbarClickListener() {
            @Override 
            public void leftClick() {
                BmobQuery<Feedback> query = new BmobQuery<>();
                query.findObjects(new FindListener<Feedback>() {
                    @Override
                    public void done(List<Feedback> list, BmobException e) {
                        if (e == null) {
                            ArrayList<String> list1 = new ArrayList<>();
                            list1.add("通知列表");
                            for (Feedback feedback : list) {
                                list1.add(feedback.getName());
                            }
                            ListView listView1 = (ListView) getActivity().findViewById(R.id.List);
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.listitem, list1);
                            listView1.setAdapter(adapter);
                            Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "查询失败，请稍后再试", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }


            public void rightClick() {
                Intent intent = new Intent(getActivity() ,fabu.class);
                startActivity(intent);
            }
            @Override
            public void centerClick() {
                Intent intent2 = new Intent(getActivity() ,Search.class);
                startActivity(intent2);
            }
        });
       return view;
            }

    @Override

        public void onActivityCreated(Bundle savedInstanceState){
            // TODO Auto-generated method stub
            super.onActivityCreated(savedInstanceState);
        Bmob.initialize(getActivity(), "bfb519d77e9049fbf4c475c3c55cc49d");
        BmobQuery<Feedback> query = new BmobQuery<>();
        query.findObjects(new FindListener<Feedback>() {
            @Override
            public void done(List<Feedback> list, BmobException e) {
                if (e == null) {
                    ArrayList<String> list1 = new ArrayList<>();
                    list1.add("通知列表");
                    for (Feedback feedback : list) {
                        list1.add(feedback.getName());
                    }
                    ListView listView1 = (ListView) getActivity().findViewById(R.id.List);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.listitem, list1);
                    listView1.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "查询失败，请稍后再试", Toast.LENGTH_SHORT).show();
                }

            }
        });
//        mSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
//        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                my_record.setText("正在刷新");
//// TODO Auto-generated method stub
//                test_type.clear();
//                test_score.clear();
//                test_time.clear();
//                initScore();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//// TODO Auto-generated method stub
//                        my_record.setText("刷新完成");
//                        mSwipeLayout.setRefreshing(false);
//                    }
//                }, 6000);
//            }
//        });
//        bu=(Button)getActivity().findViewById(R.id.button5);
//        bu.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            BmobQuery<Feedback> query = new BmobQuery<>();
//            query.findObjects(new FindListener<Feedback>() {
//                    @Override
//                    public void done(List<Feedback> list, BmobException e) {
//                        if (e == null) {
//                            ArrayList<String> list1 = new ArrayList<>();
//                            list1.add("通知列表");
//                            for (Feedback feedback : list) {
//                                list1.add(feedback.getName());
//                            }
//                            ListView listView1 = (ListView) getActivity().findViewById(R.id.List);
//                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.listitem, list1);
//                            listView1.setAdapter(adapter);
//                        } else {
//                            Toast.makeText(getActivity(), "查询失败，请稍后再试", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//            });
//
//        }
//    }
//        );
//        bu2 =(ImageButton)getActivity().findViewById(R.id.imageButton);
//        bu2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(getActivity() ,Search.class);
//                startActivity(intent2);
//            }
//        });
    }

    public static FORMFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        FORMFragment fragment = new FORMFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
