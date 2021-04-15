package vo;


public class MemberVO {

	public String email;
	public String password;
	public String phone;
	public String birthd;
	public int point;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthd() {
		return birthd;
	}
	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "AdminVO [email=" + email + ", password=" + password + ", phone=" + phone + ", birthd=" + birthd
				+ ", point=" + point + "]";
	}
	
}
