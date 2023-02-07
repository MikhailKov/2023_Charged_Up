// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.Math;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

/** Add your docs here. */
public class DriveTrain extends SubsystemBase{

    public DifferentialDrive robotDrive;

    public Victor lMotor;
    public Victor rMotor;

    public Encoder encoderL;
    public Encoder encoderR;

    public CommandXboxController driveStick;

    public DriveTrain() {
        lMotor = new Victor(RobotMap.LEFT_MOTOR_CHANNEL);
        rMotor = new Victor(RobotMap.RIGHT_MOTOR_CHANNEL);
        rMotor.setInverted(true);
        robotDrive = new DifferentialDrive(lMotor, rMotor);
        robotDrive.setSafetyEnabled(false); //??????????????
        encoderL = new Encoder(RobotMap.DRIVETRAIN_ENCODER_CHANNEL_L_A, RobotMap.DRIVETRAIN_ENCODER_CHANNEL_L_B);
        encoderR = new Encoder(RobotMap.DRIVETRAIN_ENCODER_CHANNEL_R_A, RobotMap.DRIVETRAIN_ENCODER_CHANNEL_R_B, true);
        encoderL.setDistancePerPulse(1./256.); //need to do tests to see how far it moves in 256 pulses, depends on speed tho
        encoderR.setDistancePerPulse(1./256.);

        driveStick = RobotMap.XController;
        //use encoders this year --> gives input from the motor, can help control speed
        // setDefaultCommand(new robotMovement());
    }

    public double[] check() {
        double[] thrust = ArcadeMovement.thrustConstant;
        //Imagine as vector:
        //Thrust[1] = x, Thrust[2] = y
        //find speed of encoder left
        double speedEncoderL = encoderL.getRate();       
        //find speed of encoder right
        double speedEncoderR = encoderR.getRate();
        double leftScale;
        double rightScale;

        //Used https://xiaoxiae.github.io/Robotics-Simplified-Website/drivetrain-control/arcade-drive/
        if(thrust[1] < 0) {
            leftScale = Math.abs(thrust[2])-Math.abs(thrust[1]);
            rightScale = Math.abs(thrust[2]);
        }
        else if(thrust[1] > 0) {
            rightScale = Math.abs(thrust[2])-Math.abs(thrust[1]);
            leftScale = Math.abs(thrust[2]);
        }
        else {
            rightScale = Math.abs(thrust[2]);
            leftScale = rightScale;
        }

        double speedL = speedEncoderL/leftScale;
        double speedR = speedEncoderR/rightScale;

        double error = speedL-speedR;

        speedL += (.5 * error);
        speedR -= (.5 * error);

        double[] newThrust = {thrust[0], speedEncoderL/speedL, speedEncoderR/speedR};
        System.out.println(newThrust);

        return newThrust;
    }

    // left and right = speed; 0-1??
    public void tankDrive(double left, double right) {
        robotDrive.tankDrive(left, right);
    }   


    // unreverses the x and y vals
    public void arcadeDrive(double x, double y) {
        // robotDrive.arcadeDrive(-driveStick.getRightY(), driveStick.getRightX());
        //System.out.println(-1 * y + " + " + x);        
        robotDrive.arcadeDrive(-y, -x);
    }
}