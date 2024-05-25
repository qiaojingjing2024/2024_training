package com.qiaojingjing.bookDemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class returnRecord {
    private Long id;
    private Long userId;
    private String userName;
    private Long bookId;
    private String bookName;
    private LocalDateTime returnTime;
}
