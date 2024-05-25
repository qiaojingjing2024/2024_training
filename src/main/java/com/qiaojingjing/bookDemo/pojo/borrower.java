package com.qiaojingjing.bookDemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class borrower {
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;
    private String username;
    private String password;
}
