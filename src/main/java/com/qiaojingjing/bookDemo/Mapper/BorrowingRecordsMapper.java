package com.qiaojingjing.bookDemo.Mapper;

import com.qiaojingjing.bookDemo.pojo.BorrowingRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowingRecordsMapper {

    @Select("select book_name,end_time from borrowingrecords where user_id=#{userId} and book_id=#{bookId}")
    BorrowingRecord queryBy2Id(@Param("userId") Long userId,@Param("bookId") Long bookId);

    @Select("select * from borrowingrecords where user_id = #{userId}")
    List<BorrowingRecord> queryById(Long userId);

    @Insert("insert into borrowingrecords set user_id=#{userId},book_id=#{bookId},book_name=#{bookName},begin_time=#{beginTime},end_time=#{endTime}")
    void borrow(BorrowingRecord.BorrowingRecordBuilder builder);
}
