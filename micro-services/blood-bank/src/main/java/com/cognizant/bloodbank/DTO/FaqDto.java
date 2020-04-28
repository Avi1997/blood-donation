package com.cognizant.bloodbank.DTO;

public class FaqDto {
	private int faqId ;
	private String user;
    private String question;
    private String answer;
	public FaqDto(int id ,String user, String question, String answer) {
		super();
		this.faqId = id;
		this.user = user;
		this.question = question;
		this.answer = answer;
	}
	
	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String asnswer) {
		this.answer = asnswer;
	}
    
    
}
