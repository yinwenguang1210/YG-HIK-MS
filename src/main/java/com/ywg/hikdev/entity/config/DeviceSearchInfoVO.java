package com.ywg.hikdev.entity.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 后期不提供截图，自行调接口获取
 * @author ywg
 * @date 2022/8/16 16:26
 */
@Getter
@Setter
@Deprecated
public class DeviceSearchInfoVO extends DeviceSearchInfo {
    private static final long serialVersionUID = -6507056434172863826L;
    private String screenShoot = "https://oss.ywg.com/pic/web404.jpg";
}
