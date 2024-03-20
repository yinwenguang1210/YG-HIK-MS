package com.ywg.hikdev.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ywg
 * @date 2024-3-7 17:16
 */
@Data
public class QueryRequest implements Serializable {
    private static final long serialVersionUID = 8686167312909730168L;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
