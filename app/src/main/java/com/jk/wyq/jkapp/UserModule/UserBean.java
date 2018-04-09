package com.jk.wyq.jkapp.UserModule;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Mapping;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.litesuits.orm.db.enums.Relation;

import java.util.ArrayList;

/**
 * Created by yangzhaoheng on 2018/4/7.
 */

@Table("user")
public class UserBean {

    @PrimaryKey(AssignType.BY_MYSELF)
    @Column("name")
    public String name;

    @Column("password")
    public String password;

    // 积分
    @Column("point")
    public String point;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}