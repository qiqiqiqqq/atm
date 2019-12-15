package cn.atm.entity;

import java.util.Date;

public class Record {
	private String transId;
	private Atm atm;
	private BankCard bankCard;
	private String type;
	private double transBalance;
	private Date transDate;
	private String remark;
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public Atm getAtm() {
		return atm;
	}
	public void setAtm(Atm atm) {
		this.atm = atm;
	}
	public BankCard getBankCard() {
		return bankCard;
	}
	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTransBalance() {
		return transBalance;
	}
	public void setTransBalance(double transBalance) {
		this.transBalance = transBalance;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Record [transId=" + transId + ", atm=" + atm + ", bankCard=" + bankCard + ", type=" + type
				+ ", transBalance=" + transBalance + ", transDate=" + transDate + ", remark=" + remark + "]";
	}	
}
