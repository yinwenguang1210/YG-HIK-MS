package com.ywg.hikdev.structure;

import com.ywg.hikdev.constant.HikConstant;
import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 12:32
 */
public class NET_VCA_POLYGON extends Structure
{
    public int dwPointNum;
    public NET_VCA_POINT[] struPos= new NET_VCA_POINT[HikConstant.VCA_MAX_POLYGON_POINT_NUM];
}
