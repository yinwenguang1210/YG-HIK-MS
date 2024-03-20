package com.ywg.hikdev.entity.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ywg
 * @date 2024-3-20 10:45
 */
@Data
public class AccessControlUser implements Serializable {
    private static final long serialVersionUID = 6771194369306848896L;
    /**
     * 设备ip
     */
    private String ipv4Address;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 工号
     */
    private Integer employeeNo;
    /**
     * 计划模板
     */
    private Short planTemplateNumber;
    /**
     * base64图片
     */
    private String base64Pic;
    /**
     * 多个设备
     */
    private String[] deviceIPs;
}
