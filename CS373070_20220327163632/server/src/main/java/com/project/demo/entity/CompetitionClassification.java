package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *比赛分类：(CompetitionClassification)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CompetitionClassification")
public class CompetitionClassification implements Serializable {

    //CompetitionClassification编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_classification_id")
    private Integer competition_classification_id;
    // 比赛类型
    @Basic
    private String competition_type;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
