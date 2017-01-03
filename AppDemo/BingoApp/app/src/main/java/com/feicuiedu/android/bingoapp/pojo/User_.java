package com.feicuiedu.android.bingoapp.pojo;

import java.util.Date;

import cn.bmob.v3.BmobObject;

/**
 * Created by root on 17-1-3.
 */

public class User_ extends BmobObject {

    private String name;
    private Integer sex;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
