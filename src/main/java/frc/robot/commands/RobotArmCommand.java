package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RobotArm;

public class RobotArmCommand extends CommandBase{
    private RobotArm robotArm = new RobotArm();
    private boolean goUp;
    public RobotArmCommand(RobotArm robotArm, boolean goUp) {
        this.robotArm = robotArm;
        this.goUp = goUp;
        //addRequirements(robotArm);
    }

    @Override
    public void initialize() {
        robotArm.on(goUp);
    }

    @Override
    public boolean isFinished() {
        robotArm.off();
        return true;
    }
}