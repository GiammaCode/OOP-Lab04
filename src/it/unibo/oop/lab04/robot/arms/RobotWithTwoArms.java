package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;


public class RobotWithTwoArms extends BaseRobot implements RobotWithArms  {

	private int nItems;
	
	private  BasicArm arm1 = new BasicArm("Arm 1");
	private  BasicArm arm2 = new BasicArm("Arm 2");

	
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		// TODO Auto-generated constructor stub
		this.arm1 = arm1;
		this.arm2 = arm2;
	}
	
	//interface method 
	
	public boolean pickUp() {
		nItems= 0;
		if(isBatteryEnough(BasicArm.CONSUPTION_DROPDOWN + BasicArm.CONSUPTION_PICKUP)) {
			if(!arm1.isGrabbing()) {
				nItems = 1;
				System.out.println("arm1 picking");
				return true;
			}
			if(!arm2.isGrabbing()) {
				nItems = 1;
				System.out.println("arm2 picking");
				return true;
			}
			else {
				nItems = 2;
				System.out.println("arm1 arm1 picking");
				return false;
			}
		}
		
		System.out.println("low battery");
		return false;
	
	}
	
	public boolean dropDown() {
		nItems= 0;
		if(isBatteryEnough(BasicArm.CONSUPTION_DROPDOWN + BasicArm.CONSUPTION_PICKUP)) {
			if(arm1.isGrabbing()) {
				System.out.println("arm1 drop");
				nItems = 1;
				return true;
			}
			if(arm2.isGrabbing()) {
				System.out.println("arm2 drop");
				nItems = 1;
				return true;
			}
			else {
				nItems = 2;
				System.out.println("arm1 arm1 drop");
				return false;
			}
		}
		
		System.out.println("low battery");
		return false;
	}
	
	public int getCarriedItemsCount() {
		return nItems;
	}
}
