package cn.atm.Dao;

import cn.atm.entity.*;
import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BankCardDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 按银行卡号查找
     * 多表连接查找 bankCard,bank,user
     * @param cardId
     * @return
     */
    public BankCard findById(String cardId) {
        try {
            String sql = "select * from bankcard, user, bank where bankcard.cardId=? and bankcard.userId=user.userId and bankcard.bankId=bank.bankId";
            Map<String, Object> map = qr.query(sql, new MapHandler(), cardId);
            BankCard bankCard = toBankCard(map);
            return bankCard;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新指定银行卡号的errorCount
     * @param cardId
     * @param errorCount
     */
    public void updateCardErrcount(String cardId, int errorCount) {
        try {
            String sql = "update bankcard set errorCount=? where cardId=?";
            qr.update(sql, errorCount,cardId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    /**
//     * 修改指定银行卡号的密码
//     * @param cardId
//     * @param bankCard
//     */
//    public void updateCardPasswd(String cardId, String password) {
//        try {
//            String sql = "update bankCard set password=? where cardId=?";
//            qr.update(sql, password, cardId);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
    /**
     * 把一个Map转换成BankCard对象
     * @param map
     * @return
     */
    private BankCard toBankCard(Map<String, Object> map) {
        BankCard bankCard = CommonUtils.toBean(map, BankCard.class);
        Bank bank = CommonUtils.toBean(map, Bank.class);
        User user = CommonUtils.toBean(map, User.class);
        bankCard.setBank(bank);
        bankCard.setUser(user);
        return bankCard;
    }
//
//    /**
//     * 把一个Map转换成Record对象
//     * @param map
//     * @return
//     */
//    private Record toRecord(Map<String, Object> map) {
//        Record record = CommonUtils.toBean(map, Record.class);
//        BankCard bankCard = CommonUtils.toBean(map, BankCard.class);
//        Atm atm = CommonUtils.toBean(map, Atm.class);
//        record.setAtm(atm);
//        record.setBankCard(bankCard);
//        return record;
//    }
//
    /**
     * 更新指定银行卡的cardBalance
     * @param money
     * @param cardId
     */
    public void updateBalance(double money, String cardId) {
        try {
            String sql = "update bankcard set cardBalance=cardBalance-? where cardId=?";
            qr.update(sql, money, cardId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int findTotalCount(String cardId) throws SQLException {
        String sql = "select count(*) from record WHERE record.cardId = ?";
        return ((Long)qr.query(sql, new ScalarHandler(), cardId)).intValue();
    }

    public List<Record> findByPage(int start, int rows,String cardId) {
        String sql1 = "SELECT * FROM bankcard, atms, record WHERE record.cardId = ?" +
                "AND bankcard.`cardId` = record.`cardId` AND atms.`atmId` = record.`atmId` ORDER BY transDate DESC LIMIT ?,?";
        List<Record> beanList = new ArrayList<Record>();
        List<Map<String, Object>> maps = null;
        try {
            maps = qr.query(sql1, new MapListHandler(), cardId, start, rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map<String, Object> map : maps) {
            Record record = toRecord(map);
            beanList.add(record);
        }
        return beanList;
    }

//    /**
//     * 查询所有
//     * @param pc
//     * @param ps
//     * @param cardId
//     * @return
//     */
//    public PageBean<Record> findAll(int pc, int ps, String cardId) {
//        try {
//            /*
//             * 1.创建PageBean对象pagebean
//             * 2.设置pagebean的pc和ps
//             * 3.得到tr，设置给pagebean
//             * 4.得到beanList，设置给pb
//             * 5.返回pageBean
//             */
//            PageBean<Record> pageBean = new PageBean<Record>();
//            pageBean.setPc(pc);
//            pageBean.setPs(ps);
//            /*
//             * 得到tr
//             */
//            String sql = "select count(*) from record WHERE record.cardId = ?";
//            Number number = (Number) qr.query(sql, new ScalarHandler(), cardId);
//            int tr = number.intValue();
//            pageBean.setTr(tr);
//            /*
//             * 得到beanList
//             */
//            String sql1 = "SELECT * FROM bankcard, atms, record WHERE record.cardId = ?" +
//                    "AND bankcard.`cardId` = record.`cardId` AND atms.`atmId` = record.`atmId` ORDER BY transDate DESC LIMIT ?,?";
//            List<Record> beanList = new ArrayList<Record>();
//            List<Map<String, Object>> maps = qr.query(sql1, new MapListHandler(), cardId, (pc-1)*ps, ps);
//            for (Map<String, Object> map : maps) {
//                Record record = toRecord(map);
//                beanList.add(record);
//            }
//            pageBean.setBeanList(beanList);
//            return pageBean;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 按交易ID查找该用户的交易记录
//     * @param transId
//     * @return
//     */
//    public Record findRecordById(String transId) {
//        try {
//            String sql = "SELECT * FROM bankcard, atms, record WHERE record.`transId` = ?" +
//                    "AND bankcard.`cardId` = record.`cardId` AND atms.`atmId` = record.`atmId`";
//            Map<String, Object> map = qr.query(sql, new MapHandler(), transId);
//            Record record = toRecord(map);
//            return record;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
//update bankCard set password=? where cardId=?"



    private Record toRecord(Map<String, Object> map) {
        Record record = CommonUtils.toBean(map, Record.class);
        BankCard bankCard = CommonUtils.toBean(map, BankCard.class);
        Atm atm = CommonUtils.toBean(map, Atm.class);
        record.setAtm(atm);
        record.setBankCard(bankCard);
        return record;
    }

    public void updateCardPasswd(String cardId, String password)  {

        String sql = "update bankcard set password=? where cardId=? ";
        try {
            qr.update(sql, password, cardId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
