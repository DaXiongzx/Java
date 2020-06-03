package ch3;

public class Meeting extends Task {
	public String name;
	public String time;
	public String location;
	public String receiver;
	public Meeting(String name,String time,String location,String receiver) {
		this.name=name;
		this.time=time;
		this.location=location;
		this.receiver=receiver;
	}
}
