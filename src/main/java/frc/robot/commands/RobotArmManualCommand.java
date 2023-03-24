package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.RobotArm;

public class RobotArmManualCommand extends CommandBase {

    private RobotArm robotArm;
    private boolean goDown;

    public RobotArmManualCommand(RobotArm robotArm, boolean goDown) {
        this.robotArm = robotArm;
        this.goDown = goDown;
        addRequirements(this.robotArm);
    }

    @Override
    public void initialize() {
        if(goDown) {
            robotArm.down();
        }
        else {
            robotArm.up();
        }
    }

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return (!RobotMap.XController.getXButton() && !RobotMap.XController.getBButton());
    }

    @Override
    public void end(boolean interrupted) {
        robotArm.stop();
    }
} 
// :) hi - 2023