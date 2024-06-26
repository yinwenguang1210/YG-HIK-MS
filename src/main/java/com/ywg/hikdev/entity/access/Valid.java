package com.ywg.hikdev.entity.access;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ywg
 * @date 2024-3-8 11:12
 */
@Data
public class Valid implements Serializable {

    private static final long serialVersionUID = 5595086123551302326L;
    private Boolean enable = true;
    private String timeType;
    private String beginTime = "2020-08-01T17:30:08";
    private String endTime = "2037-08-01T17:30:08";

}
