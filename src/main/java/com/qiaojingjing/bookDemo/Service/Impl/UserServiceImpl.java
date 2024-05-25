package com.qiaojingjing.bookDemo.Service.Impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.Mapper.BooksMapper;
import com.qiaojingjing.bookDemo.Result.PageResult;
import com.qiaojingjing.bookDemo.Service.userService;
import com.qiaojingjing.bookDemo.VO.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements userService {

    @Autowired
    private BooksMapper booksMapper;

    @Override
    public PageResult<BookVO> queryAll(BookDTO bookDTO) {
        int page = bookDTO.getPage();
        int pageSize = bookDTO.getPageSize();

        PageHelper.startPage(page,pageSize);

        Page<BookVO> pageData = booksMapper.queryAll(bookDTO);
        long total = pageData.getTotal();
        List<BookVO> result = pageData.getResult();

        return new PageResult<>(total,result);
    }
}
