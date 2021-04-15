package vo;

public class QuestionVO {
	
	private int seq;
	private String email;
	private String content;
	private String registration_date;
	private int secret_write;
	private String answer_content;
	private String answer_date;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public int getSecret_write() {
		return secret_write;
	}
	public void setSecret_write(int secret_write) {
		this.secret_write = secret_write;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(String answer_date) {
		this.answer_date = answer_date;
	}
	@Override
	public String toString() {
		return "QuestionVO [seq=" + seq + ", email=" + email + ", content=" + content + ", registration_date="
				+ registration_date + ", secret_write=" + secret_write + ", answer_content=" + answer_content
				+ ", answer_date=" + answer_date + "]";
	}
	
	
	
}
