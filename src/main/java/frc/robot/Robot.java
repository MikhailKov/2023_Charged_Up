/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
// import edu.wpi.first.wpilibj.PneumaticsModuleType;
//this is a test change
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
<<<<<<< Updated upstream
//import java.lang.Math;
//import frc.robot.OI; unused
// import frc.robot.commands.autonomous.*;
=======
import frc.robot.commands.autonomous.*;
>>>>>>> Stashed changes

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static DriveTrain Drive; // could be redundant , if we delete drivetrain get rid of this
  public static AprilTagVision Cameras; // used for helping line up bot thru apriltags use 16h5
  public static OI m_oi;
  public static piston m_piston;
  public static ArcadeMovement arcade;
<<<<<<< Updated upstream
  public Command m_autonomousCommand;
  public SendableChooser<Command> m_chooser;
  public int writeOnce = 0;
=======
  public static RobotArm arm;
  public static Grip grip;
  
  //Autonomous Commands, Chooser
  private static String kCharge = "Charge";
  private static String kScore = "Score";
  public String kAutonomousChoice;
  public SendableChooser<String> m_chooser;

  public static Timer time;

  //See OI.java
  public static OI m_oi;
>>>>>>> Stashed changes
  

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.42
   */
  
  @Override
  public void robotInit() {
    System.out.println("initialized robotInit");
    //startCompetition();
    RobotMap.init();
    Drive = new DriveTrain();
    Cameras = new AprilTagVision();
<<<<<<< Updated upstream
    // Cameras = new Vision();
    m_piston = new piston();
=======
    m_piston = new piston(RobotMap.p);
    arcade = new ArcadeMovement();
    arm = new RobotArm(RobotMap.ROBOT_ARM_MOTOR_ONE_CHANNEL, RobotMap.ROBOT_ARM_MOTOR_TWO_CHANNEL, .5);
    grip = new Grip(RobotMap.ROBOT_GRIP_MOTOR_CHANNEL, .5);

    //Initialize OI
>>>>>>> Stashed changes
    m_oi = new OI();
    arcade = new ArcadeMovement();
    
<<<<<<< Updated upstream

    //clampPistonTest = new ClampPistonTest(RobotMap.piston);
    // may use again later
    // m_chooser = new SendableChooser<Command>();
    // m_chooser.setDefaultOption("auto1", new ParallelCommandGroup(
    //   new dropShooter(), new scuffedCommand()
    // )
    
    // );
    // m_chooser.addOption("breakStartLine", new breakStartLine());
    // m_chooser.addOption("auto2", new auto2());
    // SmartDashboard.putData("Auto mode", m_chooser);
=======
    //Autonomous Options
    m_chooser = new SendableChooser<String>();
    m_chooser.setDefaultOption("Score --> Outside --> Charging Station", kCharge);
    m_chooser.addOption("Score --> reload --> score", kScore);

    //Add chooser to smart dashboard
    SmartDashboard.putData(m_chooser);

    time = new Timer();
>>>>>>> Stashed changes
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    arcade.periodic(); 
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    SmartDashboard.updateValues();
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    System.out.println(SmartDashboard.getKeys());
<<<<<<< Updated upstream
    m_autonomousCommand = m_chooser.getSelected();
=======

    kAutonomousChoice = m_chooser.getSelected();
    if(kAutonomousChoice.equals(kCharge)) {
      //CommandScheduler.getInstance().schedule((new PreloadScore()).andThen(new AutonomousTwo()));
      CommandScheduler.getInstance().schedule(new AutonomousTwo());
    }
    else {
      CommandScheduler.getInstance().schedule((new PreloadScore()).andThen(new AutonomousOne()).andThen(new PreloadScore()));
    }
>>>>>>> Stashed changes
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  //comment
  @Override
  public void autonomousPeriodic() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    CommandScheduler.getInstance().run();
    m_autonomousCommand = null;
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
<<<<<<< Updated upstream
    SmartDashboard.putData("Encoder", m_chooser);
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
=======
    // SmartDashboard.putData("Encoder", m_chooser);
    CommandScheduler.getInstance().cancel();
>>>>>>> Stashed changes
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
    //}
    
  }

  @Override
  public void testInit() {
    // LiveWindow.setEnabled(false);
    //robotInit();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }
}
