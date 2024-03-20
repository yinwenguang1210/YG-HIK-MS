package com.ywg.hikdev.structure;

import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 13:41
 */
public class NET_DVR_DATE extends Structure {
    public short wYear;        //年
    public byte byMonth;        //月
    public byte byDay;        //日
}
