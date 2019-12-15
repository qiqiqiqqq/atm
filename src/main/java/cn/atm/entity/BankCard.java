package cn.atm.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 实体类 银行卡
 * @author dreameros
 *
 */
public class BankCard implements HttpSessionBindingListener {
	
	private String cardId;
	private String password;
	private User user;
	private double cardBalance;
	private int errorCount;
	private Bank bank;
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "BankCard [cardId=" + cardId + ", password=" + password + ", user=" + user + ", cardBalance="
				+ cardBalance + ", errorCount=" + errorCount + ", bank=" + bank + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(event.getName());
		System.out.println("------移除------");
	}
	
	
}
