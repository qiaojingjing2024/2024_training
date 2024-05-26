package com.qiaojingjing.bookDemo.Mapper;

import com.github.pagehelper.Page;
import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.VO.BookVO;
import com.qiaojingjing.bookDemo.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BooksMapper {


    Page<BookVO> queryAll(BookDTO bookDTO);

    @Select("select * from books where id = #{bookId}")
    Book queryById(Long bookId);

    @Update("update books set borrow_number=borrow_number+1 and have_borrowed=have_borrowed+1")
    void updateBooksById(Long bookId);
}
