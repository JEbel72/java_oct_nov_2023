package thursdayWeek2Demo;

public interface Touchscreen {
	
	// Abstract methods that classes MUST define (implement)
	void turnOn();
	
	void turnOff();
	
	// Default method that classes do NOT need to define
	public default void readFingerprint() {
		System.out.println("Please enter your fingerprint:");
	}
}
