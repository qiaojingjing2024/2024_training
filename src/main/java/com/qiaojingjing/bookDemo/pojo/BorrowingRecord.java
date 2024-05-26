package com.qiaojingjing.bookDemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowingRecord {
    private Long id;
    private Long userId;
    private Long bookId;
    private String bookName;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
}
