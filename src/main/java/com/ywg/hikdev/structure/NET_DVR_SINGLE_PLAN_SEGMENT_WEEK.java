package com.ywg.hikdev.structure;

import com.ywg.hikdev.constant.HikConstant;
import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-8-16 16:45
 */
public class NET_DVR_SINGLE_PLAN_SEGMENT_WEEK extends Structure {
    public NET_DVR_SINGLE_PLAN_SEGMENT[] struPlanCfgDay = new NET_DVR_SINGLE_PLAN_SEGMENT[HikConstant.MAX_TIMESEGMENT_V30]; //一天的计划参数
}
