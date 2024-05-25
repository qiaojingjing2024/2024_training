package com.qiaojingjing.bookDemo.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private long total; //总记录数

    private List<T> records; //当前页数据集合
}
