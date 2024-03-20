package com.ywg.hikdev.service;

import com.ywg.hikdev.entity.config.DeviceInfoDTO;
import com.ywg.hikdev.entity.config.DeviceLoginDTO;
import com.ywg.hikdev.entity.config.DeviceSearchInfo;
import com.ywg.hikdev.entity.config.DeviceSearchInfoVO;

import java.util.List;

/**
 * @author ywg
 * @date 2021-5-19 13:43
 */
public interface IHikDeviceService {
    /**
     * 设备注册
     *
     * @param deviceLogin
     * @return
     */
    boolean login(DeviceLoginDTO deviceLogin);

    boolean modifyDeviceInfo(DeviceInfoDTO deviceInfoDTO);

    /**
     * 清除设备注册
     *
     * @param ip
     * @return
     */
    boolean clean(String ip);

    /**
     * 获取设备列表
     *
     * @param deviceSearchInfoVo
     * @return
     */
    @Deprecated
    List<DeviceSearchInfoVO> getDeviceList(DeviceSearchInfoVO deviceSearchInfoVo);
    List<DeviceSearchInfo> getDeviceSearchInfoList(DeviceSearchInfo deviceSearchInfo);

    /**
     * 获取登陆状态
     * @param ip
     * @return
     */
    DeviceSearchInfo loginStatus(String ip);
}
