package com.qiaojingjing.bookDemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Administrator {
    private Long id;
    private String name;
    private String username;
    private String password;
}
