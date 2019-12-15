package cn.atm.entity;

/**
 * 实体类：ATM机
 * @author dreameros
 *
 */
public class Atm {

	private String atmId;
	private double outBalance;
	private double inBalance;
//	private String bankId;
	private String atmAddress;
	private Bank bank;
	
	
//	public String getBankId() {
//		return bankId;
//	}
//	public void setBankId(String bankId) {
//		this.bankId = bankId;
//	}
//	
//	@Override
//	public String toString() {
//		return "Atm [atmId=" + atmId + ", outBalance=" + outBalance + ", inBalance=" + inBalance + ", bankId=" + bankId
//				+ ", atmAdress=" + atmAdress + "]";
//	}
	
	
	@Override
	public String toString() {
		return "Atm [atmId=" + atmId + ", outBalance=" + outBalance + ", inBalance=" + inBalance + ", atmAddress="
				+ atmAddress + ", bank=" + bank + "]";
	}
	public String getAtmAddress() {
		return atmAddress;
	}
	public void setAtmAddress(String atmAddress) {
		this.atmAddress = atmAddress;
	}
	public String getAtmId() {
		return atmId;
	}
	public void setAtmId(String atmId) {
		this.atmId = atmId;
	}
	public double getOutBalance() {
		return outBalance;
	}
	public void setOutBalance(double outBalance) {
		this.outBalance = outBalance;
	}
	public double getInBalance() {
		return inBalance;
	}
	public void setInBalance(double inBalance) {
		this.inBalance = inBalance;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
