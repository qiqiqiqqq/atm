package cn.atm.service.impl;

import cn.atm.Dao.BankCardDao;
import cn.atm.entity.BankCard;
import cn.atm.entity.PageBean;
import cn.atm.entity.Record;
import cn.atm.entity.User;
import cn.atm.exception.BankCardException;
import cn.atm.service.BankCardService;

import java.sql.SQLException;
import java.util.List;

public class BankCardImpl implements BankCardService {
    BankCardDao bankCardDao = new BankCardDao();
    @Override
    public BankCard login(BankCard bankCard) {



        return null;
    }

    @Override
    public void changePasswd(String cardId, String password) throws BankCardException {
        BankCard bankCard = bankCardDao.findById(cardId);
        if (bankCard.getUser().getUserId().contains(password)) {

                throw new BankCardException("密码不能包含身份证号字段");

        }
        bankCardDao.updateCardPasswd(cardId, password);

    }

    /**
     * 分页查询
     * @param _currentPage
     * @param _rows
     * @return
     */
    @Override
  public PageBean<Record> findRecordsByPage(String _currentPage, String _rows,String carId) throws SQLException {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage<=0){
            currentPage = 1;
        }
        BankCardDao dao = new BankCardDao();
        int totalCount  = dao.findTotalCount(carId);
        int totalPage =  totalCount % rows == 0 ? totalCount/rows : (totalCount/rows) +1;
        if(currentPage>=totalPage){
            currentPage=totalPage;
        }
       PageBean<Record> pb = new PageBean<>();

        pb.setCurrenPage(currentPage);
        pb.setRows(rows);


        pb.setTotalCount(totalCount);
        int start = (currentPage-1)*rows;
        List<Record> list = dao.findByPage(start,rows,carId);
        pb.setList(list);



        pb.setTotalPage(totalPage);
        return pb;
   }

}