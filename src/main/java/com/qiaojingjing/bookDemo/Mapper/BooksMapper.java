package com.qiaojingjing.bookDemo.Mapper;

import com.github.pagehelper.Page;
import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.VO.BookVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BooksMapper {


    Page<BookVO> queryAll(BookDTO bookDTO);
}
