package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *场地信息：(SiteInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "SiteInformation")
public class SiteInformation implements Serializable {

    //SiteInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "site_information_id")
    private Integer site_information_id;
    // 场地编号
    @Basic
    private String site_number;
    // 场地类型
    @Basic
    private String site_type;
    // 场地名称
    @Basic
    private String site_name;
    // 场地地址
    @Basic
    private String site_address;
    // 封面
    @Basic
    private String cover;
    // 备注
    @Basic
    private String remarks;
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
