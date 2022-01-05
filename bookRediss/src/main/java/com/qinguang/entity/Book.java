package com.qinguang.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zam
 * @date 2021/12/23 -17:10
 */

@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String isbn;
    private BigDecimal price;
    private Date create_time;
}
