package org.usfirst.frc.team2145.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2145.robot.RobotMap;

public class Lift extends Subsystem {
	
	TalonSRX liftMotor = new TalonSRX(RobotMap.liftMotor);
	Encoder liftEncoder = new Encoder(RobotMap.liftEncoder1,RobotMap.liftEncoder2);

	@Override
	protected void initDefaultCommand() {
		

	
	}
	
	public void liftDrive(double liftSpeed) {
		liftMotor.set(liftSpeed);
	
	}
	
	
	
}
