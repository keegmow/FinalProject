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
	
	
}
