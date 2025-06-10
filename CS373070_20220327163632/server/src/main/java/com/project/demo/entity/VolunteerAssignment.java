package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *志愿者分配：(VolunteerAssignment)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VolunteerAssignment")
public class VolunteerAssignment implements Serializable {

    //VolunteerAssignment编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteer_assignment_id")
    private Integer volunteer_assignment_id;
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
    // 安排时间
    @Basic
    private String schedule_time;
    // 注意事项
    @Basic
    private String matters_needing_attention;
    // 服务岗位
    @Basic
    private String service_post;
    // 志愿者
    @Basic
    private Integer volunteer;
    // 比赛名称
    @Basic
    private String competition_name;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
