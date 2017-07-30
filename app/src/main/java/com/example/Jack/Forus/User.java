package com.example.Jack.Forus;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Jack on 2017/7/10.
 */

public class User extends BmobUser {
   private BmobFile Photo;
   private String Email;

    public String getEmail(){
        return Email;
    }
    public void setEmail(String email){
        Email = email;
    }
    public BmobFile getPhoto() {
    return Photo;
    }
    public void setPhoto(BmobFile photo) {
        Photo = photo;
        }

}

