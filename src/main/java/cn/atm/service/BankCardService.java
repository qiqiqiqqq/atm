package cn.atm.service;

import cn.atm.entity.BankCard;
import cn.atm.entity.PageBean;
import cn.atm.entity.Record;
import cn.atm.entity.User;
import cn.atm.exception.BankCardException;

import java.sql.SQLException;

public interface BankCardService {

    BankCard login(BankCard bankCard);

    PageBean<Record> findRecordsByPage(String currentPage, String rows,String carId) throws SQLException;

    void changePasswd(String cardId, String password) throws BankCardException, SQLException;
}
