package com.havila.pojo;
import java.util.List;


public class StudentsGroup {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getCombination() {
		return combination;
	}
	public void setCombination(String combination) {
		this.combination = combination;
	}
	String std;
	String sec;
	String combination;
	@Override
	public String toString() {
		return "StudentsGroup [id=" + id + ", std=" + std + ", sec=" + sec
				+ ", combination=" + combination + "]";
	}

}
