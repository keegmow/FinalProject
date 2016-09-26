package com.krho.finalproject;

import javax.persistence.*;


@Entity
@Table(name = "activities")
public class Activity {
	
	@Id @GeneratedValue @Column(name = "ID")
	private int id;
	
	@Column (name = "ActivityName")
	private String activityName;
	
	//First Question
	@Column (name = "stayHome")
	private boolean stayHome = false;
	
	//Second Question
	@Column (name = "Inside")
	private boolean inside = false;
	
	//Third Question
	@Column (name = "Family")
	private boolean family = false;
	@Column (name = "Friends")
	private boolean friends = false;
	@Column (name = "Myself")
	private boolean myself = false;
	
	//Fourth Question
	@Column (name = "Potato")
	private boolean potato = false;
	@Column (name = "Interactive")
	private boolean interactive = false;
	@Column (name = "Exercise")
	private boolean exercise = false;
	
	//Fifth Question
	@Column (name = "Paid")
	private boolean paid = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public boolean isStayHome() {
		return stayHome;
	}

	public void setStayHome(boolean stayHome) {
		this.stayHome = stayHome;
	}

	public boolean isInside() {
		return inside;
	}

	public void setInside(boolean inside) {
		this.inside = inside;
	}

	public boolean isFamily() {
		return family;
	}

	public void setFamily(boolean family) {
		this.family = family;
	}

	public boolean isFriends() {
		return friends;
	}

	public void setFriends(boolean friends) {
		this.friends = friends;
	}

	public boolean isMyself() {
		return myself;
	}

	public void setMyself(boolean myself) {
		this.myself = myself;
	}

	public boolean isPotato() {
		return potato;
	}

	public void setPotato(boolean potato) {
		this.potato = potato;
	}

	public boolean isInteractive() {
		return interactive;
	}

	public void setInteractive(boolean interactive) {
		this.interactive = interactive;
	}

	public boolean isExercise() {
		return exercise;
	}

	public void setExercise(boolean exercise) {
		this.exercise = exercise;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	Question quest = new Question();
	

	
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
		if (answer.equals(quest.getChoice3a())) 
			family = true;
		if (answer.equals(quest.getChoice3b())) 
			friends = true;
		if (answer.equals(quest.getChoice3c()))
			myself = true;
		
	}
	private void setAnswer4Query(String answer) {
		if (answer.equals(quest.getChoice4a())) 
			potato = true;
		if (answer.equals(quest.getChoice4b())) 
			interactive = true;
		if (answer.equals(quest.getChoice4c())) 
			exercise = true;
		
	}
	private void setAnswer5Query(String answer) {
		if (answer.equals(quest.getChoice5a())) {
			paid = true;
		}
	}
	
	public String buildQuery(ActivityQuery finalQuery) {
		
		stayHome = false;
		inside = false;
		family = false;
		friends = false;
		myself = false;
		potato = false;
		interactive = false;
		exercise = false;
		paid = false;
		
		setAnswer1Query(finalQuery.getAnswer1());
		
		if (finalQuery.getAnswer2() != null) {
			setAnswer2Query(finalQuery.getAnswer2());
		}
		if (finalQuery.getAnswer3() != null) {
			setAnswer3Query(finalQuery.getAnswer3());
		}
		if (finalQuery.getAnswer4() != null) {
			setAnswer4Query(finalQuery.getAnswer4());
		}
		if (finalQuery.getAnswer5() != null) {
			setAnswer5Query(finalQuery.getAnswer5());
		}
		
		String column1 = "stayHome";
		String column2 = "Inside";
		String column3 = "Family";
		String column4 = "Friends";
		String column5 = "Myself";
		String column6 = "Potato";
		String column7 = "Interactive";
		String column8 = "Exercise";
		String column9 = "Paid";
		
		String query = "WHERE " + column1 + " = " + stayHome;
	
		
		if(inside == true) {
			query = query + " and " + column2 + " = " + inside;
		}
		
		
		if (family == true) {
			query = query + " and " + column3 + " = " + family;
		}
		if (friends == true) {
			query = query + " and " + column4 + " = " + friends;
		}
		if (myself == true) {
			query = query + " and " + column5 + " = " + myself;
		}
		
		if (potato == true) {
			query = query + " and " + column6 + " = " + potato;
		}
		if (interactive == true) {
			query = query + " and " + column7 + " = " + interactive;
		}
		if (exercise == true) {
			query = query + " and " + column8 + " = " + exercise;
		}
		
		if (paid == false) {
			query = query + " and " + column9 + " = " + paid;
		}
		
		if(finalQuery.getAnswer1().equals(quest.supriseMe)) {
			query = "";
		}
//		System.out.println("before DAO is called" + query);
		return query;
	}
	
}
