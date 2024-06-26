package com.ywg.hikdev.structure;

import com.ywg.hikdev.constant.HikConstant;
import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 13:29
 */
public class NET_DVR_TPS_INFO_V41 extends Structure {
    public int dwLanNum;          // 交通参数的车道数目
    public NET_DVR_LANE_PARAM_V41[]  struLaneParam= new NET_DVR_LANE_PARAM_V41[HikConstant.MAX_TPS_RULE];
    public int dwSceneID;//场景ID
    public byte[] byRes = new byte[28];         //保留
}
