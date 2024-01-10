package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.RobotArm;

public class RobotArmAutoCommand extends CommandBase {

    private RobotArm robotArm;
    private boolean goDown;
    Timer time;

    public RobotArmAutoCommand(RobotArm robotArm, boolean goDown) {
        this.robotArm = robotArm;
        this.goDown = goDown;
        addRequirements(this.robotArm);
    }

    @Override
    public void initialize() {
        time = new Timer();
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
        return time.hasElapsed(2);
    }

    @Override
    public void end(boolean interrupted) {
        robotArm.stop();
    }
} 
// :) hi - 2023