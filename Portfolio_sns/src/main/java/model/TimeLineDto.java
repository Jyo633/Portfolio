package model;
import java.sql.Timestamp;

public class TimeLineDto {
	
private String name ;
private String userId ;
private String sentence ;
private Timestamp postTime ;

public String getName() { return name;}
public void setName(String name) {	this.name = name;}

public String getUserId() {	return userId;}
public void setUserId(String userId) {	this.userId = userId;}

public String getSentence() {	return sentence;}
public void setSentence(String sentence) {	this.sentence = sentence;}

public Timestamp getPostTime() {	return postTime;}
public void setPostTime(Timestamp postTime) {	this.postTime = postTime;}

}
