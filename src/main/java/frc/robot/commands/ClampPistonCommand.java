package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClampPiston;

public class ClampPistonCommand extends CommandBase {
    private final ClampPiston piston;

    public ClampPistonCommand(ClampPiston piston) {
        this.piston = piston;
        System.out.println("initialize clampPistonCommand");
        //addRequirements(piston);
    }

    @Override 
    public void initialize() {
        piston.toggleSolenoid();
        System.out.println("attempt clampPistonCommand");
    }

    @Override 
    public boolean isFinished() {return true;}
}