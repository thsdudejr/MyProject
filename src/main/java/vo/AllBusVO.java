package vo;

import lombok.Data;

public class AllBusVO {
	
	private String area;
	private String terminal_name;
	private String terminal_address;
	private String terminal_phone;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTerminal_name() {
		return terminal_name;
	}
	public void setTerminal_name(String terminal_name) {
		this.terminal_name = terminal_name;
	}
	public String getTerminal_address() {
		return terminal_address;
	}
	public void setTerminal_address(String terminal_address) {
		this.terminal_address = terminal_address;
	}
	public String getTerminal_phone() {
		return terminal_phone;
	}
	public void setTerminal_phone(String terminal_phone) {
		this.terminal_phone = terminal_phone;
	}
	@Override
	public String toString() {
		return "AllBusVO [area=" + area + ", terminal_name=" + terminal_name + ", terminal_address=" + terminal_address
				+ ", terminal_phone=" + terminal_phone + "]";
	}
	
	

}
