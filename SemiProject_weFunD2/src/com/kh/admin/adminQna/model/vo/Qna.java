package com.kh.admin.adminQna.model.vo;
public class Qna {
	
    private int qnaNo; //QNA_NO NUMBER PRIMARY KEY ,
    private String qnaWriter; //QNA_WRITER NUMBER REFERENCES MEMBER(USER_NO)  NOT NULL,
    private String qnaTitle; //QNA_TITLE VARCHAR2(100) NOT NULL ,
    private String qnaContent; //QNA_CONTENT VARCHAR2(3000) NOT NULL ,
    private String qnaDate; //QNA_DATE DATE DEFAULT SYSDATE NOT NULL,
    private String answer; //ANSWER VARCHAR2(3000),
    private String answerDate; //ANSWER_DATE DATE DEFAULT SYSDATE,
    private String status; //STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')) NOT NULL
    
	public Qna() {
		super();
	}
	
	public Qna(int qnaNo, String qnaWriter, String qnaTitle, String qnaDate, String answer) {
		super();
		this.qnaNo = qnaNo;
		this.qnaWriter = qnaWriter;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.answer = answer;
	}
	
	public Qna(int qnaNo, String qnaWriter, String qnaTitle, String qnaContent, String qnaDate, String answer,
			String answerDate) {
		super();
		this.qnaNo = qnaNo;
		this.qnaWriter = qnaWriter;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.answer = answer;
		this.answerDate = answerDate;
	}

	public Qna(int qnaNo, String qnaWriter, String qnaTitle, String qnaContent, String qnaDate, String answer,
			String answerDate, String status) {
		super();
		this.qnaNo = qnaNo;
		this.qnaWriter = qnaWriter;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.answer = answer;
		this.answerDate = answerDate;
		this.status = status;
	}

	public Qna(int qnaNo, String qnaTitle, String qnaWriter, String qnaDate) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaWriter = qnaWriter;
		this.qnaDate = qnaDate;
	}

	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "QNA [qnaNo=" + qnaNo + ", qnaWriter=" + qnaWriter + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaDate=" + qnaDate + ", answer=" + answer + ", answerDate=" + answerDate
				+ ", status=" + status + "]";
	}
    
}