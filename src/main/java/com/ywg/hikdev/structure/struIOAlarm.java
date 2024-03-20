package com.ywg.hikdev.structure;

import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 12:14
 */
public class struIOAlarm extends Structure {
    public int dwAlarmInputNo;
    public int dwTrigerAlarmOutNum;
    public int dwTrigerRecordChanNum;
}
