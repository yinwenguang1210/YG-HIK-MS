package com.ywg.hikdev.structure;

import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 13:09
 */
public class NET_VCA_DEV_INFO extends Structure {
    public NET_DVR_IPADDR struDevIP;
    public short wPort;
    public byte byChannel;
    public byte byIvmsChannel;
}
