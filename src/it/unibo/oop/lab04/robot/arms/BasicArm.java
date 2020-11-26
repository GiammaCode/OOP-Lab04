package it.unibo.oop.lab04.robot.arms;


public class BasicArm {
	
	final static double CONSUPTION_PICKUP = 1.5;
	final static double CONSUPTION_DROPDOWN = 1.0;
	private String ArmName;
	private boolean grabbing;
	
	
	public BasicArm(final String ArmName) {
		this.ArmName = ArmName;
	}
	
	public void pickUp() {
		grabbing = true;
	}
	
	public void  dropDown() {
		grabbing = false;
	}
	
	protected boolean isGrabbing() {
		return grabbing;
	}
	
	public double getConsuptionForPickUp() {
		return CONSUPTION_PICKUP;
	}
	
	public double getConsuptionForDropDown() {
		return CONSUPTION_DROPDOWN;
	}
		
	public String toString() {
		return "[" + "ArmName= " + ArmName + ", counsuption for pickup= "
				+ CONSUPTION_PICKUP + ", consuption for dropdown" 
				+ CONSUPTION_DROPDOWN + "]";
	}
}
