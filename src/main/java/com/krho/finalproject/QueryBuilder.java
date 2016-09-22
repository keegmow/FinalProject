package com.krho.finalproject;


public class QueryBuilder {

	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	
	//First Question
	public boolean stayHome = false;
	//Second Question
	public boolean inside = false;
	//Third Question
	public boolean family = false;
	public boolean friends = false;
	public boolean myself = false;
	//Fourth Question
	public boolean potato = false;
	public boolean interactive = false;
	public boolean exercise = false;
	//Fifth Question
	public boolean paid = false;
	
	Question quest = new Question();
	
	
	public QueryBuilder(ActivityQuery query) {
		answer1 = query.getAnswer1();
		answer2 = query.getAnswer2();
		answer3 = query.getAnswer3();
		answer4 = query.getAnswer4();
		answer5 = query.getAnswer5();
		setAnswer1Query(answer1);
		setAnswer2Query(answer2);
		setAnswer3Query(answer3);
		setAnswer4Query(answer4);
		setAnswer5Query(answer5);
	}
	
	private void setAnswer1Query(String answer) {
		if (answer.equals(quest.getChoice1a())) {
			stayHome = true;
		}
	}
	private void setAnswer2Query(String answer) {
		if (answer.equals(quest.getChoice2a())) {
			inside = true;
		}
	}
	private void setAnswer3Query(String answer) {
		if (answer.equals(quest.getChoice3a())) {
			family = true;
		} else if (answer.equals(quest.getChoice3b())) {
			friends = true;
		} else if (answer.equals(quest.getChoice3c())){
			myself = true;
		}
	}
	private void setAnswer4Query(String answer) {
		if (answer.equals(quest.getChoice4a())) {
			potato = true;
		} else if (answer.equals(quest.getChoice4b())) {
			interactive = true;
		} else if (answer.equals(quest.getChoice4c())) {
			exercise = true;
		}
	}
	private void setAnswer5Query(String answer) {
		if (answer.equals(quest.getChoice5a())) {
			paid = true;
		}
	}
	
	public String buildQuery() {
		
		String column1 = "stayHome";
		String column2 = "Inside";
		String column3 = "Family";
		String column4 = "Friends";
		String column5 = "Myself";
		String column6 = "Potato";
		String column7 = "Interactive";
		String column8 = "Exercise";
		String column9 = "Paid";
		
		String query = "WHERE " + column1 + " = " + stayHome +
						" and " + column2 + " = " + inside;
		
		if (family = true) {
			query = query + " and " + column3 + " = " + family;
		} else if (friends = true) {
			query = query + " and " + column4 + " = " + friends;
		} else {
			query = query + " and " + column5 + " = " + myself;
		}
		
		if (potato = true) {
			query = query + " and " + column6 + " = " + potato;
		} else if (interactive = true) {
			query = query + " and " + column7 + " = " + interactive;
		} else {
			query = query + " and " + column8 + " = " + exercise;
		}
		
		if (paid = false) {
			query = query + " and " + column9 + " = " + paid;
		}
		
//		String query = "WHERE " +
//					column1 + " = " + stayHome + " and " +
//					column2 + " = " + inside  + " and " +
//					column3 + " = " + family  + " and " +
//					column4 + " = " + friends  + " and " +
//					column5 + " = " + myself  + " and " +
//					column6 + " = " + potato  + " and " +
//					column7 + " = " + interactive  + " and " +
//					column8 + " = " + exercise  + " and " +
//					column9 + " = " + paid;
					
		return query;
	}	
}
