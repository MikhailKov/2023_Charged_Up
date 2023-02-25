// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/** Add your docs here. */
public class DriveTrain extends SubsystemBase{

    public DifferentialDrive robotDrive;

    public Victor lMotor;
    public Victor rMotor;

    public Encoder encoderL;
    public Encoder encoderR;

    public XboxController driveStick;

    public DriveTrain() {
        lMotor = new Victor(RobotMap.LEFT_MOTOR_CHANNEL);
        rMotor = new Victor(RobotMap.RIGHT_MOTOR_CHANNEL);
        rMotor.setInverted(true);
        robotDrive = new DifferentialDrive(lMotor, rMotor);
        robotDrive.setSafetyEnabled(false);
        encoderL = new Encoder(RobotMap.DRIVETRAIN_ENCODER_CHANNEL_L_A, RobotMap.DRIVETRAIN_ENCODER_CHANNEL_L_B);
        encoderR = new Encoder(RobotMap.DRIVETRAIN_ENCODER_CHANNEL_R_A, RobotMap.DRIVETRAIN_ENCODER_CHANNEL_R_B, true);
        encoderL.setDistancePerPulse(18.859/256.); //need to do tests to see how far it moves in 256 pulses, depends on speed tho
        encoderR.setDistancePerPulse(18.859/256.);

        driveStick = RobotMap.XController;
        //use encoders this year --> gives input from the motor, can help control speed
        // setDefaultCommand(new robotMovement());
    }

    public void tankDrive(double left, double right) {
        robotDrive.tankDrive(left, right);
    }   


    // X tells us how much to rotate: positive is going to be counterclockwise with this method, so we need to invert it
    // Y tells us how much forward, and it is reversed with the joystick.
    public void arcadeDrive(double x, double y) {
        robotDrive.arcadeDrive(-y, -x);
    }
}