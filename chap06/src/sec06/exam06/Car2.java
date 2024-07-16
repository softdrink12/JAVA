package sec06.exam06;

public class Car2 {

	private int speed; 
	private boolean stop;
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
//	public boolean getStop() {		<= is보다 get이 더 안전하다 
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	
}
