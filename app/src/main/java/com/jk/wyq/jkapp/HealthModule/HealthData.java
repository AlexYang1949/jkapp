package com.jk.wyq.jkapp.HealthModule;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by yangzhaoheng on 2018/3/1.
 */

@Table("HealthDB")
public class HealthData {
    @PrimaryKey(AssignType.BY_MYSELF)
    private String name;

    @Column("date")
    private String date;

    // 年龄
    @Column("age")
    private int age;

    // 体重
    @Column("weight")
    private int weight;

    // 体重
    @Column("height")
    private int height;

    // 心跳
    @Column("beat")
    private int beat;


}
