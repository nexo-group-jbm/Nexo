package com.cors.Model;

public class Greeting {
private long id;
private String content;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getContent() {
	return content;
}
//public Greeting() {
//	this.id=0;
//	this.content="";
//}
public Greeting(long id, String content) {
	super();
	this.id = id;
	this.content = content;
}
public void setContent(String content) {
	this.content = content;
}

}
