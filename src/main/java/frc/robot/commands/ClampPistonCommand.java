package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.piston;

public class ClampPistonCommand extends CommandBase {
    private piston p;
    
    public ClampPistonCommand(piston aPiston) {
        p = aPiston;
        addRequirements(p);
    }

    @Override
    public void initialize() {
        p.toggleSolenoid();
        System.out.println("initialized ClampPistonCommand");
       
    }

    @Override
    public void execute() {}

    @Override 
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return true;
    }
}
