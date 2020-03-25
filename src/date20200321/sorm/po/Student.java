package date20200321.sorm.po;

import java.sql.*;
import java.util.*;

public class Student {

	private java.sql.Blob head;
	private java.sql.Timestamp lastLoginTime;
	private java.sql.Date regTime;
	private String name;
	private Integer id;
	private Integer age;
	private String info;


	public java.sql.Blob getHead(){
		return head;
	}
	public java.sql.Timestamp getLastLoginTime(){
		return lastLoginTime;
	}
	public java.sql.Date getRegTime(){
		return regTime;
	}
	public String getName(){
		return name;
	}
	public Integer getId(){
		return id;
	}
	public Integer getAge(){
		return age;
	}
	public String getInfo(){
		return info;
	}
	public void setHead(java.sql.Blob head){
		this.head = head;
	}
	public void setLastLoginTime(java.sql.Timestamp lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}
	public void setRegTime(java.sql.Date regTime){
		this.regTime = regTime;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	public void setInfo(String info){
		this.info = info;
	}
}
