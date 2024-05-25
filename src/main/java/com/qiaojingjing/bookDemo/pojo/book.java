package com.qiaojingjing.bookDemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class book {
    private Long id;
    private String name;
    private String author;
    private String isbn;
    private String press;
    private Integer count;
    private Double price;
    private Integer borrowNumber;
    private Integer haveBorrowed;
    private LocalDateTime createTime;
    private String createUser;
}