package cn.atm.Dao;

import cn.atm.entity.Atm;
import cn.atm.entity.Bank;
import cn.atm.entity.Record;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AtmDao {
	private QueryRunner qr = new TxQueryRunner();
//	/**
//	 * 通过ATM编号查找ATM机
//	 * @param atmId
//	 * @return
//	 */
//	public Atm findById(String atmId) {
//		try {
//			String sql = "select * from atms, bank where atmId=? and bank.bankId=atms.bankId;";
//			Map<String, Object> map = qr.query(sql, new MapHandler(), atmId);
//			Atm atm = toAtm(map);
//			return atm;
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	/**
	 * 把一个Map转换成一个Atm对象
	 * @param map
	 * @return
	 */
	private Atm toAtm(Map<String, Object> map) {
		Atm atm = CommonUtils.toBean(map, Atm.class);
		Bank bank = CommonUtils.toBean(map, Bank.class);
		atm.setBank(bank);
		return atm;
	}
//
//	/**
//	 * 更新指定ATM机的outMoney
//	 * @param money
//	 * @param atmId
//	 */
//	public void updateOut(double money, String atmId) {
//		try {
//			String sql = "update atms set outBalance=outBalance-? where atmId=?";
//			qr.update(sql, money, atmId);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 更新指定ATM机的inMoney
//	 * @param money
//	 * @param atmId
//	 */
//	public void updateIn(double money, String atmId) {
//		try {
//			String sql = "update atms set inBalance=inBalance+? where atmId=?";
//			qr.update(sql, money, atmId);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 查找附近所有的银行
//	 * @return
//	 */
//	public List<Atm> findNear() {
//		List<Atm> atms = new ArrayList<Atm>();
//		try {
//			String sql = "select * from atms, bank where atms.bankId = bank.bankId";
//			List<Map<String, Object>> maps = qr.query(sql, new MapListHandler());
//			for (Map<String, Object> map : maps) {
//				Atm atm = toAtm(map);
//				atms.add(atm);
//			}
//			return atms;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	/**
	 * 插入一条交易记录
	 * @param record
	 */
	public void addRecord(Record record) {
		try {
			Object[] params = {record.getTransId(), record.getBankCard().getCardId(),
					"BC_001", record.getType(), record.getTransBalance(),
					record.getTransDate(), record.getRemark()};
			System.out.println(params[1]);
			String sql = "insert into record values(?,?,?,?,?,?,?)";
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
