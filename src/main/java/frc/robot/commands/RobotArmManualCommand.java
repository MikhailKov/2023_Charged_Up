package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.RobotArm;

public class RobotArmManualCommand extends CommandBase {

    private RobotArm robotArm;
    private boolean goUp;

    public RobotArmManualCommand(RobotArm robotArm) {
        this.robotArm = robotArm;
        this.goUp = false;
        addRequirements(this.robotArm);
    }

    @Override
    public void initialize() {
        if(goUp) {
            robotArm.up();
        }
        else {
            robotArm.down();
        }
    }

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return (!goUp && !RobotMap.XController.getXButton()) || (goUp && !RobotMap.XController.getBButton());
    }

    @Override
    public void end(boolean interrupted) {
        robotArm.stop();
    }
} 
// :) hi - 2023