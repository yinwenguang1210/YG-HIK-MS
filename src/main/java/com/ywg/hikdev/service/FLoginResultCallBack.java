package com.ywg.hikdev.service;

import com.ywg.hikdev.structure.NET_DVR_DEVICEINFO_V30;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

/**
 * 登录回调
 * @author ywg
 * @date 2021-5-12 15:30
 */
public interface FLoginResultCallBack extends StdCallCallback {
    int invoke(int lUserID, int dwResult, NET_DVR_DEVICEINFO_V30 lpDeviceinfo, Pointer pUser);
}
