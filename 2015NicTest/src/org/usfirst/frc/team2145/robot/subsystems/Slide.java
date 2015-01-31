package org.usfirst.frc.team2145.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;



public class Slide extends Subsystem{
	
	Talon slideMotor = new Talon(1);
	
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extendWithController(double extendSpeed){
    	slideMotor.set(extendSpeed);
    }

}
