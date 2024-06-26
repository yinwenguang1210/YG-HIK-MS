package com.ywg.hikdev.service;

import com.ywg.hikdev.structure.NET_DVR_ALARMER;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

/**
 * @author ywg
 * @date 2021-6-17 12:25
 */
public interface FMSGCallBack extends StdCallLibrary.StdCallCallback {
    void invoke(int lCommand, NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser);
}
