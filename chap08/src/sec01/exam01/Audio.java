package sec01.exam01;

public class Audio implements RemoteControl{

	int volume;
	
	
	@Override
	public void turnOn() {
		System.out.println("audio 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("audio 끕니다");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			volume = RemoteControl.MAX_VOLUME;
		} else if(volume > RemoteControl.MIN_VOLUME) {
			volume = RemoteControl.MIN_VOLUME;
		} 
		
		this.volume = volume;
		
		System.out.println("audio 현재 볼륨 : " + this.volume);
	}
	
	

}
