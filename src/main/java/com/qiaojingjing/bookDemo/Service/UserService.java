package com.qiaojingjing.bookDemo.Service;

import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.DTO.BorrowDTO;
import com.qiaojingjing.bookDemo.Result.PageResult;
import com.qiaojingjing.bookDemo.VO.BookVO;
import com.qiaojingjing.bookDemo.VO.BorrowedBookVO;

import java.util.List;

public interface UserService {
    PageResult<BookVO> queryAll(BookDTO bookDTO);

    void borrow(BorrowDTO borrowDTO);

    List<BorrowedBookVO> queryBorrowedBooks(Long userId);
}
