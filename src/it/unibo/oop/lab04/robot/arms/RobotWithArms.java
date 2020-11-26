package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

public interface RobotWithArms extends Robot{
	
	/**
	 * 		picks an object
	 *@return
	 *		true if the action is successful 
	 */
	boolean pickUp();
	
	
	/**
	 *		down an object
	 *@return
	 * 		true if the action is successful
	 */
	boolean dropDown();
	
	/**
	 *@return
	 *		int of objects this robot is 
	 *		currently transporting 
	 */
	int getCarriedItemsCount();
}
