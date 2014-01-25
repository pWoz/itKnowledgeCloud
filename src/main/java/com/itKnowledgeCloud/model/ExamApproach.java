package com.itKnowledgeCloud.model;

import java.util.Date;

public class ExamApproach {

	private Exam exam;
	private User user;
	private Date approachDate;
	
	public ExamApproach(Exam exam, User user) {
		this.exam = exam;
		this.user = user;
		this.approachDate = new Date();
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getApproachDate() {
		return approachDate;
	}

	public void setApproachDate(Date approachDate) {
		this.approachDate = approachDate;
	}
	
	
	
}
