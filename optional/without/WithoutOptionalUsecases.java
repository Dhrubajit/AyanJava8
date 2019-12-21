package optional.without;

public class WithoutOptionalUsecases {

	public static void main(String[] args) {
		Computer computer = getComputerAfterPerformingBusinessLogic();
		//Following code has potential to throw NullPointerException
		//As we don't know if the reference variable on which we are calling
		//method is null or not.
		String version1 = computer.getSoundcard().getUsb().getVersion();
		
		//To avoid NullPointerException we will have to write defensive coding
		//which will reduce code readability
		String version2 = null;
		if(computer != null){
			Soundcard soundcard = computer.getSoundcard();
			if(soundcard != null){
				USB usb = soundcard.getUsb();
				if(usb != null){
					version2 = usb.getVersion();
				}
			}
		}

	}

	//API which will return the object of type Computer
	public static Computer getComputerAfterPerformingBusinessLogic(){
		Computer computer = new Computer("PC");
		return computer;
	}
}

//If we have a pojo like the following it is not evident from the code of pojo
//that one of the field can be null. As there is no marker.
class Computer{
	
	private String name;
	private Soundcard soundcard;
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
	public Soundcard getSoundcard() {
		return soundcard;
	}
	public void setSoundcard(Soundcard soundcard) {
		this.soundcard = soundcard;
	}
}

class Soundcard{
	private String type;
	private USB usb;
	public Soundcard(String type) {
		super();
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public USB getUsb() {
		return usb;
	}
	public void setUsb(USB usb) {
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
	
}