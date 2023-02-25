/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
// import edu.wpi.first.wpilibj.XboxController;
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

        // Digital (0-9, 10-25)
        // TESTING BOT
        public static int LEFT_MOTOR_CHANNEL = 0, RIGHT_MOTOR_CHANNEL = 1;
        
        // motor based
        public static int ROBOT_ARM_MOTOR_ONE_CHANNEL = 2, ROBOT_ARM_MOTOR_TWO_CHANNEL = 3;
        public static int ROBOT_ARM_ENCODER_ONE_CHANNEL_A = 4, ROBOT_ARM_ENCODER_ONE_CHANNEL_B = 5, ROBOT_ARM_ENCODER_TWO_CHANNEL_A = 6, ROBOT_ARM_ENCODER_TWO_CHANNEL_B = 7;

        public static int DRIVETRAIN_ENCODER_CHANNEL_L_A = 0, DRIVETRAIN_ENCODER_CHANNEL_L_B = 1, DRIVETRAIN_ENCODER_CHANNEL_R_A = 2, DRIVETRAIN_ENCODER_CHANNEL_R_B = 3;

        public static int ROBOT_GRIP_MOTOR_CHANNEL = 4;

        //Command Stuff
        public static Trigger top, triggerJoystick, aButton, bButton, xButton, yButton, backButton, startButton, leftBumper, rightBumper, leftStickButton, rightStickButton, leftTrigger, rightTrigger;
        public static CommandJoystick analogLeft, analogRight;
        public static final int XBOX_PORT = 0;
        public static final XboxController XController = new XboxController(XBOX_PORT);
        
        // link to how pneumatics channels work here https://docs.wpilib.org/en/stable/docs/software/hardware-apis/pneumatics/pneumatics.html
        //Piston Stuff
        public static final int PISTON_CHANNEL = 1;
        public static Solenoid p = new Solenoid(0, PneumaticsModuleType.CTREPCM, 1);
        
        public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

        //ultrasonic sensors - 195 inches probably
        // public static AnalogPotentiometer frontUltrasonic = new AnalogPotentiometer(0, 195, 0);
        // public static AnalogPotentiometer backUltrasonic = new AnalogPotentiometer(0, 195, 0);


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
                aButton = new JoystickButton(XController, XboxController.Button.kA.value);
                bButton = new JoystickButton(XController, XboxController.Button.kB.value);
                xButton = new JoystickButton(XController, XboxController.Button.kX.value);
                yButton = new JoystickButton(XController, XboxController.Button.kY.value);
                leftBumper = new JoystickButton(XController, XboxController.Button.kLeftBumper.value);
                rightBumper = new JoystickButton(XController, XboxController.Button.kRightBumper.value);
                backButton = new JoystickButton(XController, XboxController.Button.kBack.value);
                startButton = new JoystickButton(XController, XboxController.Button.kStart.value);
                leftStickButton = new JoystickButton(XController, XboxController.Button.kLeftStick.value);
                //rightStickButton = new JoystickButton(XController, 10);
                analogLeft = new CommandJoystick(1);


                // analogRight = new Joystick(2);
        }
}