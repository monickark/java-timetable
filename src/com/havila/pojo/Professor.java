package com.havila.pojo;
import java.util.List;


public class Professor {
	@Override
	public String toString() {
		return "Professor [id=" + id + ", prof_name=" + prof_name + "]";
	}
	Integer id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	String prof_name;
	public String getProf_name() {
		return prof_name;
	}
	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}	

}
