/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
        public static final double PERIODIC_UPDATE_PERIOD = 0.020; // Periodic update period (s)

        // Power Channels
        public static final int DRIVE_POWER_LEFT_FRONT = 837148, DRIVE_POWER_RIGHT_FRONT = 378149,
                        DRIVE_POWER_LEFT_REAR = 893149, DRIVE_POWER_RIGHT_REAR = 81340723, CAMERA_ONE_POWER = 0,
                        CAMERA_TWO_POWER = 1, VRM_POWER = 38578942;

        // Camera Resolution Dimensions
        public static final int CAM_WID = 640, CAM_HEI = 480;

        // piston based
        public static int GRIPPER_CHANNEL_A = 0, GRIPPER_CHANNEL_B = 2;

        // Drive system PID Parameters
        public static final double DRIVE_PID_POSITION_KP = 2.00, // 2.00
                        DRIVE_PID_POSITION_KI = 0.01, // 0.01
                        DRIVE_PID_POSITION_KD = 1.00, // 1.00
                        DRIVE_PID_ANGLE_KP = 0.02, DRIVE_PID_ANGLE_KI = 0.001, DRIVE_PID_ANGLE_KD = 0.0;

        // Digital (0-9, 10-25)
        // TESTING BOT
        public static int LEFT_MOTOR_CHANNEL = 0, RIGHT_MOTOR_CHANNEL = 1;
        // 2022 bot
        //public static int LEFT_MOTOR_CHANNEL = 9, RIGHT_MOTOR_CHANNEL = 8;
        
        // motor based
        public static int ROBOT_ARM_MOTOR_ONE_CHANNEL = 2, ROBOT_ARM_MOTOR_TWO_CHANNEL = 3;

        public static int DRIVETRAIN_ENCODER_CHANNEL_L_A = 0, DRIVETRAIN_ENCODER_CHANNEL_L_B = 1, DRIVETRAIN_ENCODER_CHANNEL_R_A = 2, DRIVETRAIN_ENCODER_CHANNEL_R_B = 3;
        //public static int SHOOTER_ENCODER_CHANNEL_A = 0, SHOOTER_ENCODER_CHANNEL_B = 1;

        // HARDWARE
        
        //public static MotorController lift;

        // state for lift motor
        //public static boolean liftStart = false;

        
        public static Trigger aButton, bButton, xButton, yButton, backButton, startButton, leftBumper, rightBumper, leftStickButton, rightStickButton, leftTrigger, rightTrigger;
        public static Joystick analogLeft, analogRight;
        public static final int XBOX_PORT = 0;
        public static final CommandXboxController XController = new CommandXboxController(XBOX_PORT);
        
        public static final int PISTON_CHANNEL = 0;
        public static Solenoid piston = new Solenoid(PneumaticsModuleType.CTREPCM, PISTON_CHANNEL);

        // For example to map the left and right motors, you could define the
        // following variables to use with your drivetrain subsystem.
        // public static int leftMotor = 1;
        // public static int rightMotor = 2;

        // If you are using multiple modules, make sure to define both the port
        // number and the module. For example you with a rangefinder:
        // public static int rangefinderPort = 1;
        // public static int rangefinderModule = 1;
        public static void init() {
                //map each button to a JoystickButton
                aButton = XController.a();
                bButton = XController.b();
                xButton = XController.x();
                yButton = XController.y();
                leftBumper = XController.leftBumper();
                rightBumper = XController.rightBumper();
                leftTrigger = XController.leftTrigger();
                rightTrigger = XController.rightTrigger();
                backButton = XController.back();
                startButton = XController.start();
                leftStickButton = XController.leftStick();
                //rightStickButton = new JoystickButton(XController, 10);
                analogLeft = new Joystick(1);
                // analogRight = new Joystick(2);
        }
}