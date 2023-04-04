package com.hjr.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements Serializable {

    private static final long serialVersionUID = -4234823827123409L;

    private Long id;
    private String menuName;
    private String path;
    private String component;
    private String visible;
    private String status;
    private String perms;
    private String icon;
    private Long createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    private Integer delFlag;
    private String remark;
}
