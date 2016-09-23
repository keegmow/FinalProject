package com.krho.finalproject;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ActivityQuery {

	private int queryId;
	private String answer1 = null;
	private String answer2 = null;
	private String answer3 = null;
	private String answer4 = null;
	private String answer5 = null;
	
	
	@NotNull(message = "Please enter 5 digit zipcode")
	@Size(min=5, max=5, message = "Please enter 5 digit zipcode")
	private String zipcode;
	
	
	
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

//    private static final ActivityQuery instance = new ActivityQuery();
//    
//    //private constructor to avoid client applications to use constructor
//    private ActivityQuery(){}
//
//    public static ActivityQuery getInstance(){
//        return instance;
//		}
       
    public ActivityQuery(){};

    
	
}
