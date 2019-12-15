package cn.atm.controller;

import cn.atm.Dao.AtmDao;
import cn.atm.Dao.BankCardDao;
import cn.atm.entity.Atm;
import cn.atm.entity.BankCard;
import cn.atm.entity.Record;
import cn.atm.exception.BankCardException;
import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.JdbcUtils;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AtmService {
	private AtmDao atmDao = new AtmDao();
	private BankCardDao bankCardDao = new BankCardDao();
	
	public void checkBalance(String cardId) {
		
	}
	

	public void withdraw(double money, String cardId, String atmId) {
		try {
			JdbcUtils.beginTransaction();
			bankCardDao.updateBalance(money, cardId);
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e2) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 存款(事务操作)
	 * ATM存款箱+money
	 * BankCard+money
	 * @param money
	 * @param cardId
	 * @param atmId
	 */
	public void deposit(double money, String cardId) {
		try {
			JdbcUtils.beginTransaction();
			bankCardDao.updateBalance(money*(-1), cardId);
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e2) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * ATM查找要转账的BankCard
	 * @param cardId
	 * @return
	 * @throws BankCardException
	 */
	public BankCard findCard(String cardId) throws BankCardException {
		BankCard bankCard = bankCardDao.findById(cardId);
		if (bankCard.getCardId() == null) {
			throw new BankCardException("该银行卡账户不存在");
		}
		if (bankCard.getErrorCount() == 0) {
			throw new BankCardException("该账户已被冻结");
		}
		return bankCard;
	}

	public void transfer(double outMoney, double fee, String cardId, String cardId2) {
		try {
			JdbcUtils.beginTransaction();
			bankCardDao.updateBalance(outMoney+fee, cardId);
			bankCardDao.updateBalance(outMoney*(-1), cardId2);
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e2) {
				throw new RuntimeException(e);
			}
		}
	}



	/**
	 * 添加交易记录
	 * @param record
	 */
	public void addRecord(Record record) {
		try {
			atmDao.addRecord(record);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public void record(String cardId, String type, double transBalance, String remark) {
		Date nowDate = new Date();
		DateFormat format = new SimpleDateFormat("\"yyyy年MM月dd日 HH:mm:ss\"");
		String now = format.format(nowDate);
		System.out.println("---------" + type + "(时间点)---------");
		System.out.println(now);

		Record record = new Record();
		BankCard bankCard = new BankCard();
		Atm atm = new Atm();
		record.setBankCard(bankCard);
		record.setAtm(atm);

		record.setTransId(CommonUtils.uuid());
		record.getBankCard().setCardId(cardId);
		record.setType(type);
		record.setTransBalance(transBalance);
		record.setTransDate(nowDate);
		record.setRemark(remark);
		System.out.println(record);
		addRecord(record);
	}
}
