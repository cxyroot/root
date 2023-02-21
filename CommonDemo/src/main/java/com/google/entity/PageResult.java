package com.google.entity;

import java.util.List;

/**
 * 描述：
 * <p>
 * author caoxiaoyang
 * date 2021-05-27
 * version
 */
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }


}
