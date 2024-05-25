package com.qiaojingjing.bookDemo.DTO;

import lombok.Data;

@Data
public class BookDTO {
    private String name;  //书名
    private String author;  //作者
    private String isbn;  //ISBN号
    private String press;  //出版社
    private int page;  //页码
    private int pageSize;  //页面大小
}
