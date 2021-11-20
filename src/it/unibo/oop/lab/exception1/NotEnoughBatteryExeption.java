package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryExeption extends IllegalStateException {

	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double batteryRequired;
	
	public NotEnoughBatteryExeption(final double battery, final double requirement) {
		super();
		this.batteryLevel = battery;
		this.batteryRequired = requirement;
	}

	public String toString() {
		return "Can't move anymore [battery is at" + batteryLevel + "%] [required " 
				+ batteryRequired + "%]";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	

}
