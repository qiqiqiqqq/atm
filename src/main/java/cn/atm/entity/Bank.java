package cn.atm.entity;

/**
 * 实体类：银行
 * @author dreameros
 *
 */
public class Bank {

	private String bankId;
	private String bankName;
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}	
}
