package com.qiaojingjing.bookDemo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowDTO {
    private Long userId;  //借阅者id
    private Long bookId;  //图书id
    private String beginTime;  //借阅开始时间
    private String endTime;  //借阅结束时间
}
