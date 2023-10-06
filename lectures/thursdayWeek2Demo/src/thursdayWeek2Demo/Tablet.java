package thursdayWeek2Demo;

public class Tablet implements Touchscreen {
	private String brandName;
	private String name;
	private int memory;
	private int storage;
	
	// Implementing the abstract methods
	@Override
	public void turnOn() {
		System.out.println("Press the power button to turn on this tablet");
	}

	@Override
	public void turnOff() {
		System.out.println("Press the power button to turn this off");
	}

	// Constructors
	public Tablet() {
	}

	public Tablet(String brandName, String name, int memory, int storage) {
		this.brandName = brandName;
		this.name = name;
		this.memory = memory;
		this.storage = storage;
	}

	// Getters and setters
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	
	
}
