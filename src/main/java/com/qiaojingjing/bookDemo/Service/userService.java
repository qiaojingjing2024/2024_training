package com.qiaojingjing.bookDemo.Service;

import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.Result.PageResult;
import com.qiaojingjing.bookDemo.VO.BookVO;

public interface userService {
    PageResult<BookVO> queryAll(BookDTO bookDTO);
}
