package model;

public class Article extends Entity {
	private String link, authorName, subject, content;
	private Time writingTime;
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Time getWritingTime() {
		return writingTime;
	}
	
	public void setWritingTime(Time writingTime) {
		this.writingTime = writingTime;
	}
	
	
}
