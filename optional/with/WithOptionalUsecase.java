package optional.with;

import java.util.Optional;

public class WithOptionalUsecase {

	public static void main(String[] args) throws IllegalAccessException {
		Computer computer = getComputerAfterPerformingBusinessLogic();
		
		//Following line will give us NoSuchElementException(RuntimeException)
		//if Optional value is not set. So we are bound to handle the scenario.
		//Soundcard soundcard = computer.getSoundcard().get();
		
		Soundcard defaultSoundcard = computer.getSoundcard().orElse(new Soundcard("default"));
		
		//Soundcard soundcardExceptionThrow = computer.getSoundcard().orElseThrow(IllegalAccessException::new);
		
		Soundcard soundcardSupplier = computer.getSoundcard().orElseGet(() -> new Soundcard("default"));
		
		Optional<Soundcard> optSoundCard = computer.getSoundcard();
		Optional<Optional<USB>> usb = optSoundCard.map(Soundcard::getUsb);
		System.out.println(soundcardSupplier);
	}
	
	//API which will return the object of type Computer
	public static Computer getComputerAfterPerformingBusinessLogic(){
		Computer computer = new Computer("PC");
		//case 1
		//it will be job of API to set empty optional
		//in case it is not supposed to have any value.
		computer.setSoundcard(Optional.empty());
		
		//case 2
		//if it is supposed to have some value
		// then we can do like following
		Soundcard soundcard1 = new Soundcard("HiFi");
		computer.setSoundcard(Optional.of(soundcard1));
		
		//case 3
		//It will throw NullPointerException
		//Soundcard soundcard2 = null;
		//computer.setSoundcard(Optional.of(soundcard2));
		
		//case 4
		//If we don't want NullPointerException and
		//still unsure about the fact that whether 
		//the reference will be null or not and we get the object 
		//without optional wrapper we can use the following method instead
		Soundcard soundcard3 = null;
		computer.setSoundcard(Optional.ofNullable(soundcard3));
		
		return computer;
	}


}

//From this code it is evident that Optional field may or may not hold a value.
//So we should handle that scenario. If we want to model some field as optional 
//and in that case we should do some thing, then only we should use Optional wrapper.

//We can read it as Computer may or may not have a soundcard
class Computer{

	private String name;
	private Optional<Soundcard> soundcard;
	public Computer(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<Soundcard> getSoundcard() {
		return soundcard;
	}
	public void setSoundcard(Optional<Soundcard> soundcard) {
		this.soundcard = soundcard;
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + ", soundcard=" + soundcard + "]";
	}

}

class Soundcard{
	private String type;
	private Optional<USB> usb;
	public Soundcard(String type) {
		super();
		this.type = type;
	}
	@Override
	public String toString() {
		return "Soundcard [type=" + type + ", usb=" + usb + "]";
	}
	public Optional<USB> getUsb() {
		return usb;
	}
	public void setUsb(Optional<USB> usb) {
		this.usb = usb;
	}


}

class USB{
	private String version;

	public USB(String version) {
		super();
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "USB [version=" + version + "]";
	}

}