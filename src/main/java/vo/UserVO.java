package vo;

public class UserVO {

	private String email;
	private String password;
	private String phone;
	private String birthd;
	private int point;
	private String registration_date;

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

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
		return "UserVO [email=" + email + ", password=" + password + ", phone=" + phone + ", birthd=" + birthd
				+ ", point=" + point + ", registration_date=" + registration_date + "]";
	}

	

}
