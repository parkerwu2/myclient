package com.wjz.myclient.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by jingzhi.wu on 2018/1/31.
 */
@Data
public class TestParam {
    @NotNull(message = "test不能为空")
    private String test;
}
