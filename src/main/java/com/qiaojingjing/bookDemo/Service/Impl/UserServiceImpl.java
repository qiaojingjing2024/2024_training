package com.qiaojingjing.bookDemo.Service.Impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiaojingjing.bookDemo.Cons.Message;
import com.qiaojingjing.bookDemo.DTO.BookDTO;
import com.qiaojingjing.bookDemo.DTO.BorrowDTO;
import com.qiaojingjing.bookDemo.Exception.CountException;
import com.qiaojingjing.bookDemo.Exception.HasBorrowedException;
import com.qiaojingjing.bookDemo.Mapper.BooksMapper;
import com.qiaojingjing.bookDemo.Mapper.BorrowingRecordsMapper;
import com.qiaojingjing.bookDemo.Result.PageResult;
import com.qiaojingjing.bookDemo.Service.UserService;
import com.qiaojingjing.bookDemo.Utils.String2Date;
import com.qiaojingjing.bookDemo.VO.BookVO;
import com.qiaojingjing.bookDemo.VO.BorrowedBookVO;
import com.qiaojingjing.bookDemo.pojo.Book;
import com.qiaojingjing.bookDemo.pojo.BorrowingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BooksMapper booksMapper;
    @Autowired
    private BorrowingRecordsMapper borrowingRecordsMapper;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void borrow(BorrowDTO borrowDTO) {
        /*
        * 约束1：如果书没有余量了，提示"此书余量为0"
        * 约束2: 如果已经借了这本书，提示"您已经借了此书还未归还"
         TODO
        * 约束3: 如果有书超过还书日期未归还,提示"您还有书为归还"
        * */
        Long bookId = borrowDTO.getBookId();
        Long userId = borrowDTO.getUserId();
        Book book = booksMapper.queryById(bookId);
        Integer count = book.getCount();
        Integer borrowNumber = book.getBorrowNumber();
        if(count-borrowNumber<=0){
            throw new CountException(Message.COUNT_EXCEPTION);
        }
        BorrowingRecord borrowingRecord =  borrowingRecordsMapper.queryBy2Id(userId,bookId);
        if(borrowingRecord!=null){
            throw new HasBorrowedException(Message.HAS_BORROWED);
        }

        String time1 = borrowDTO.getBeginTime();
        String time2 = borrowDTO.getEndTime();
        LocalDateTime beginTime = String2Date.string2Date(time1);
        LocalDateTime endTime = String2Date.string2Date(time2);

        BorrowingRecord.BorrowingRecordBuilder builder = BorrowingRecord.builder().userId(userId)
                .bookId(bookId)
                .bookName(book.getName())
                .beginTime(beginTime)
                .endTime(endTime);

        borrowingRecordsMapper.borrow(builder);
        booksMapper.updateBooksById(bookId);
    }

    @Override
    public List<BorrowedBookVO> queryBorrowedBooks(Long userId) {
        return borrowingRecordsMapper.query(userId);
    }


}
