package model;

public class Fact<TObject1, TObject2> extends Entity {
	private TObject1 Object1;
	private TObject2 Object2;
	private Time time;
	private String subject, relationship;
	private int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public TObject1 getObject1() {
		return Object1;
	}
	
	public void setObject1(TObject1 object1) {
		Object1 = object1;
	}
	
	public TObject2 getObject2() {
		return Object2;
	}
	
	public void setObject2(TObject2 object2) {
		Object2 = object2;
	}
	
	public Time getTime() {
		return time;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getRelationship() {
		return relationship;
	}
	
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	
}
