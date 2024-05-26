package com.qiaojingjing.bookDemo.Controller;


import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.DTO.BorrowDTO;
import com.qiaojingjing.bookDemo.Result.PageResult;
import com.qiaojingjing.bookDemo.Result.Result;
import com.qiaojingjing.bookDemo.Service.UserService;
import com.qiaojingjing.bookDemo.VO.BookVO;
import com.qiaojingjing.bookDemo.VO.BorrowedBookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrower")
@Slf4j
public class userController {

    @Autowired
    private UserService userService;

    //分页查询所有图书
    @GetMapping("/query")
    public Result queryAll(BookDTO bookDTO){
        log.info("查询图书...");
        PageResult<BookVO> pageResult =  userService.queryAll(bookDTO);
        return Result.success(pageResult);
    }

    //请求借阅接口
    @PostMapping("/borrow")
    public Result borrow(@RequestBody BorrowDTO borrowDTO){
        log.info("借阅图书,{}",borrowDTO);
        userService.borrow(borrowDTO);
        return Result.success();
    }

    //查询已经借的书接口
    @GetMapping("/queryBooks")
    public Result borrowedBooks(Long userId){
        log.info("查询用户ID为{}借的书",userId);
        List<BorrowedBookVO> list = userService.queryBorrowedBooks(userId);
        return Result.success(list);
    }

}
