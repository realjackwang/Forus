package com.example.Jack.Forus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.bmob.v3.Bmob;

import static android.app.Activity.RESULT_CANCELED;

public class MeFragment extends Fragment {
   private FragmentActivity mContext;
    private ImageView faceImage;
    private Button btn;
    private LinearLayout layout;
    private TextView nicheng1;
    private ImageView switchAvatar;
    private String[] items = new String[] { "选择本地图片" };
    private static final String IMAGE_FILE_NAME = "faceImage.jpg";
    private static final int IMAGE_REQUEST_CODE = 0;
    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int RESULT_REQUEST_CODE = 2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me, container, false);

        Topbar topbar1 = (Topbar)view.findViewById(R.id.MyTopbar1);
        faceImage = (ImageView) view.findViewById(R.id.iv_head);
        nicheng1 =(TextView)view.findViewById(R.id.textView) ;
        switchAvatar = (ImageView) view.findViewById(R.id.iv_head);
        switchAvatar.setOnClickListener(listener);
        topbar1.setLeftButtonIsVisiable(false);
        topbar1.setRightButtonIsVisiable(false);
        topbar1.setCenterButtonIsVisiable(false);
        topbar1.setOnTopbarClickListener(new Topbar.topbarClickListener() {
            public void leftClick() {
            }
            public void rightClick(){
            }
            public void centerClick(){
            }

        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        Bmob.initialize(getActivity(), "bfb519d77e9049fbf4c475c3c55cc49d");

        layout=(LinearLayout)getActivity().findViewById(R.id.person12);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testSharedPreference();
                Intent intent = new Intent(getActivity() ,uesri.class);
               startActivity(intent);
            }
        });
//
//        btn=(Button)getActivity().findViewById(R.id.button3);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity() ,Main2Activity.class);
//               startActivity(intent);
//            }
//        });
    }
    public void testSharedPreference() {      //昵称转移
        try {
            Context context = getContext().createPackageContext("cn.itcast.sharedpreferences", Context.CONTEXT_IGNORE_SECURITY);
            SharedPreferences sharedPreference = context.getSharedPreferences("test", Context.MODE_PRIVATE);
            String nicheng= sharedPreference.getString("昵称", "");
            nicheng1.setText(nicheng);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static MeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            showDialog();
        }
    };

    private void showDialog() {

        new AlertDialog.Builder(getActivity())
                .setTitle("设置头像")
                .setItems(items, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent intentFromGallery = new Intent();
                                intentFromGallery.setType("image/*"); // 设置文件类型
                                intentFromGallery
                                        .setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(intentFromGallery,
                                        IMAGE_REQUEST_CODE);
                                break;
//                            case 1:
//
//                                Intent intentFromCapture = new Intent(
//                                        MediaStore.ACTION_IMAGE_CAPTURE);
//                                // 判断存储卡是否可以用，可用进行存储
//                                if (Tools.hasSdcard()) {
//
//                                    intentFromCapture.putExtra(
//                                            MediaStore.EXTRA_OUTPUT,
//                                            Uri.fromFile(new File(Environment
//                                                    .getExternalStorageDirectory(),
//                                                    IMAGE_FILE_NAME)));
//                                }
//
//                                startActivityForResult(intentFromCapture,
//                                        CAMERA_REQUEST_CODE);
//                                break;
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

    }

    @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //结果码不等于取消时候
        if (resultCode != RESULT_CANCELED) {

            switch (requestCode) {
                case IMAGE_REQUEST_CODE:
                    startPhotoZoom(data.getData());
                    break;
//                case CAMERA_REQUEST_CODE:
//                    if (Tools.hasSdcard()) {
//                        File tempFile = new File(
//                                Environment.getExternalStorageDirectory()
//                                        + IMAGE_FILE_NAME);
//                        startPhotoZoom(Uri.fromFile(tempFile));
//                    }
//                  else
//                      {
//                        Toast.makeText(getActivity(), "未找到存储卡，无法存储照片！",
//                                Toast.LENGTH_LONG).show();
//                    }

//                    break;
                case RESULT_REQUEST_CODE:
                    if (data != null) {
                        getImageToView(data);
                    }
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void startPhotoZoom(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 2);
    }

    private void getImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Drawable drawable = new BitmapDrawable(photo);
            faceImage.setImageDrawable(drawable);
        }
    }
}

