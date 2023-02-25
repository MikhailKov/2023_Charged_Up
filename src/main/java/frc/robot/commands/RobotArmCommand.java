package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.RobotArm;

public class RobotArmCommand extends CommandBase {
    private static Encoder e1 = new Encoder(RobotMap.ROBOT_ARM_ENCODER_ONE_CHANNEL_A, RobotMap.ROBOT_ARM_ENCODER_ONE_CHANNEL_B);
    private static Encoder e2 = new Encoder(RobotMap.ROBOT_ARM_ENCODER_TWO_CHANNEL_A, RobotMap.ROBOT_ARM_ENCODER_TWO_CHANNEL_B, true);
    private static int state = 0;

    private RobotArm robotArm;
    private boolean goUp;

    public RobotArmCommand(RobotArm robotArm, boolean goUp) {
        this.robotArm = robotArm;
        this.goUp = goUp;
        addRequirements(this.robotArm);
        e1.setDistancePerPulse(360./256.);
        e2.setDistancePerPulse(360./256.);
    }

    @Override
    public void initialize() {};

    @Override
    public void execute() {
        if(goUp) {
            robotArm.up();
        }
        else {
            robotArm.down();
        }
    }

    @Override
    public boolean isFinished() {
        if (goUp && state == 0) {
            if (e1.getDistance() >= 10.655 && e2.getDistance() >= 10.655) {
                state = 1;
                return true;
            } else {
                return false;
            }
        }
        else if (goUp && state == 1) {
            if (e1.getDistance() >= 43.457 && e2.getDistance() >= 43.457) {
                state = 2;
                return true;
            } else {
                return false;
            }
        }
        else if (goUp && state == 2) {
            if (e1.getDistance() >= 13.597 && e2.getDistance() >= 13.597) {
                state = 3;
                return true;
            } else {
                return false;
            }
        }
        else if (goUp && state == 3) {
            return true;
        }
        else if (!goUp && state == 0) {
            return true;
        }
        else if (!goUp && state == 1) {
            if (e1.getDistance() <= -10.655 && e2.getDistance() <= -10.655) {
                state = 0;
                return true;
            } else {
                return false;
            }
        }
        else if (!goUp && state == 2) {
            if (e1.getDistance() <= -43.457 && e2.getDistance() <= -43.457) {
                state = 1;
                return true;
            } else {
                return false;
            }
        }
        else if (!goUp && state == 3) {
            if (e1.getDistance() <= -13.597 && e2.getDistance() <= -13.597) {
                state = 2;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        robotArm.stop();
        e1.reset();
        e2.reset();
    }
} 
// :) hi - 2023