package com.revpassword.model;

public class SecurityQuestion {
	 private int questionId;
	    private int userId;
	    private String questionText;
	    private String answer;

	    public SecurityQuestion() {
	    }

	    public SecurityQuestion(int questionId, int userId, String questionText, String answer) {
	        this.questionId = questionId;
	        this.userId = userId;
	        this.questionText = questionText;
	        this.answer = answer;
	    }

	    public int getQuestionId() {
	        return questionId;
	    }

	    public void setQuestionId(int questionId) {
	        this.questionId = questionId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public String getQuestionText() {
	        return questionText;
	    }

	    public void setQuestionText(String questionText) {
	        this.questionText = questionText;
	    }

	    public String getAnswer() {
	        return answer;
	    }

	    public void setAnswer(String answer) {
	        this.answer = answer;
	    }

}
