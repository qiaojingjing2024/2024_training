package com.qiaojingjing.bookDemo.Controller;


import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.Result.PageResult;
import com.qiaojingjing.bookDemo.Result.Result;
import com.qiaojingjing.bookDemo.Service.userService;
import com.qiaojingjing.bookDemo.VO.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrower")
@Slf4j
public class userController {

    @Autowired
    private userService userService;

    //分页查询所有图书
    @GetMapping("/query")
    public Result queryAll(BookDTO bookDTO){
        PageResult<BookVO> pageResult =  userService.queryAll(bookDTO);
        return Result.success(pageResult);
    }

}
