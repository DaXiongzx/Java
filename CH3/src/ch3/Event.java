package ch3;

public class Event extends Task{
	public String name;
	public String time;
	public String location;
	public String receiver;
	public Event(String name,String time,String location,String receiver) {
		this.name=name;
		this.time=time;
		this.location=location;
		this.receiver=receiver;
	}
}