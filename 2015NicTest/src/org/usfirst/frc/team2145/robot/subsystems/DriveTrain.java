package org.usfirst.frc.team2145.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2145.robot.commands.DriveWithController;
import org.usfirst.frc.team2145.robot.RobotMap;


public class DriveTrain extends Subsystem{
	
	TalonSRX frontRightWheel = new TalonSRX(RobotMap.frontRightWheel);
	TalonSRX frontLeftWheel = new TalonSRX(RobotMap.frontLeftWheel);
	TalonSRX backRightWheel = new TalonSRX(RobotMap.backRightWheel);
	TalonSRX backLeftWheel = new TalonSRX(RobotMap.backLeftWheel);
	
	Encoder backRightEncoder = new Encoder(RobotMap.backRightEncoder1,RobotMap.backRightEncoder2);
	Encoder backLeftEncoder= new Encoder(RobotMap.backLeftEncoder1,RobotMap.backLeftEncoder2);
	
	Gyro gyro = new Gyro(RobotMap.driveGyro);
	
	
	
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithController());
    }
	
	public void MecanumDrive (double X,double Y,double Z) {
	   
		double forward= Y;
		double right= X;
		double clockwise= Z;
		//Gets Directions like from Joy Sticks.
		
		double front_left = forward + clockwise + right;
		double front_right = forward - clockwise- right;
		double rear_left = forward + clockwise - right;
		double rear_right = forward - clockwise + right;
		//Kinetic Data for Mech Wheels
		
		double max = Math.abs(front_left);
		if (Math.abs(front_right)>max) max=Math.abs(front_right);
		if (Math.abs(rear_left)>max) max= Math.abs(rear_left);
		if (Math.abs(rear_right)>max) max= Math.abs(rear_right);
		//Determines highest going Motor
		
		if (max>1)
		{front_left/=max; front_right/=max; rear_left/=max; rear_right/=max;}
		//Makes it so none can be above 1
		
		frontRightWheel.set(front_right);
		frontLeftWheel.set(-front_left);
		backRightWheel.set(rear_right);
		backLeftWheel.set(-rear_left);
		//Sends Data to Talons
	}
	
	@SuppressWarnings("deprecation")
	public void logDrive(){
		double encoderAverage = (backRightEncoder.getDistance() + backLeftEncoder.getDistance()) / 2;
		SmartDashboard.putDouble("Encoder Avg", encoderAverage);
		
	}
		
	
	

}
