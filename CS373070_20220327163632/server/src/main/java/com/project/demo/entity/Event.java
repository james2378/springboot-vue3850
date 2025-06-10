package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *比赛项目：(Event)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Event")
public class Event implements Serializable {

    //Event编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer event_id;
    // 比赛编号
    @Basic
    private String competition_number;
    // 比赛类型
    @Basic
    private String competition_type;
    // 项目类型
    @Basic
    private String project_type;
    // 场地名称
    @Basic
    private String site_name;
    // 比赛时间
    @Basic
    private String game_time;
    // 比赛人数
    @Basic
    private Integer number_of_matches;
    // 封面
    @Basic
    private String cover;
    // 裁判姓名
    @Basic
    private String referee_name;
    // 比赛名称
    @Basic
    private String competition_name;
    // 比赛要求
    @Basic
    private String competition_requirements;
    // 比赛奖励
    @Basic
    private String competition_reward;
    // 裁判简介
    @Basic
    private String referee_profile;
    // 点击数
    @Basic
    private Integer hits;
    // 点赞数
    @Basic
    private Integer praise_len;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
