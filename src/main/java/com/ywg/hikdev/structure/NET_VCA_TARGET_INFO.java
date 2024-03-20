package com.ywg.hikdev.structure;

import com.sun.jna.Structure;

/**
 * @author ywg
 * @date 2021-5-18 13:08
 */
public class NET_VCA_TARGET_INFO extends Structure
{
    public int dwID;
    public NET_VCA_RECT struRect;
    public byte[] byRes= new byte[4];
}
