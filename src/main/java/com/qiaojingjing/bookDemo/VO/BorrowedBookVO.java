package com.qiaojingjing.bookDemo.VO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowedBookVO {
    private Long id;
    private String name;
    private String author;
    private String isbn;
    private String press;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
}
