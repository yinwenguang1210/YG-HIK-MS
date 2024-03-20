package com.ywg.hikdev.structure;

import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 12:15
 */
public class NET_DVR_TIME_EX extends Structure {
    public short wYear;
    public byte byMonth;
    public byte byDay;
    public byte byHour;
    public byte byMinute;
    public byte bySecond;
    public byte byRes;
}
