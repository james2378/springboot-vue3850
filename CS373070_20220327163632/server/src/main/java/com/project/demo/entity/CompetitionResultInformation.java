package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *比赛成绩信息：(CompetitionResultInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CompetitionResultInformation")
public class CompetitionResultInformation implements Serializable {

    //CompetitionResultInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_result_information_id")
    private Integer competition_result_information_id;
    // 比赛编号
    @Basic
    private String competition_number;
    // 比赛类型
    @Basic
    private String competition_type;
    // 比赛名称
    @Basic
    private String competition_name;
    // 场地名称
    @Basic
    private String site_name;
    // 成绩分数
    @Basic
    private Integer score;
    // 运动员
    @Basic
    private Integer athletes;
    // 封面
    @Basic
    private String cover;
    // 项目类型
    @Basic
    private String project_type;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
