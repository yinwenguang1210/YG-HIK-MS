package com.ywg.hikdev.structure;

import com.ywg.hikdev.constant.HikConstant;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-14 14:50
 */
public class NET_DVR_FACE_RECORD extends Structure {
    public int dwSize;
    public byte[] byCardNo = new byte[HikConstant.ACS_CARD_NO_LEN];
    public int dwFaceLen;
    public Pointer pFaceBuffer;
    public byte[] byRes = new byte[128];
}
