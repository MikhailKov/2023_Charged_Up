/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import frc.robot.commands.*;

/**
 * This class is what binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public OI() {
    RobotMap.backButton.onTrue(new ClampPistonCommand(Robot.m_piston));

    RobotMap.xButton.whileTrue(new RobotArmManualCommand(Robot.arm, false));
    RobotMap.bButton.whileTrue(new RobotArmManualCommand(Robot.arm, true));

    RobotMap.yButton.onTrue(new SpeedUp(false));
    RobotMap.aButton.onTrue(new SpeedUp(true));

    RobotMap.rightBumper.whileTrue(new GripCommand(Robot.grip, true));
    RobotMap.leftBumper.whileTrue(new GripCommand(Robot.grip, false));
  }
}
