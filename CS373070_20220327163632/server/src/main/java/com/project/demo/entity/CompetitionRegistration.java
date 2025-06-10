package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *比赛报名：(CompetitionRegistration)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CompetitionRegistration")
public class CompetitionRegistration implements Serializable {

    //CompetitionRegistration编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_registration_id")
    private Integer competition_registration_id;
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
    // 报名时间
    @Basic
    private String registration_time;
    // 姓名
    @Basic
    private String full_name;
    // 性别
    @Basic
    private String gender;
    // 联系方式
    @Basic
    private String contact_information;
    // 年龄
    @Basic
    private String age;
    // 运动员
    @Basic
    private Integer athletes;
    // 比赛名称
    @Basic
    private String competition_name;
    // 审核状态
    @Basic
    private String examine_state;
    // 审核回复
    @Basic
    private String examine_reply;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
