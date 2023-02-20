package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.piston;

public class printMessage extends CommandBase {
    private piston message;
    private boolean done = false;
    
    public printMessage(piston aPiston) {
        this.message = aPiston;
        addRequirements(message);
    }

    @Override
    public void initialize() {
        System.out.println("p");
        done = true;
    }

    @Override
    public void execute() {
        System.out.println("p");
        done = true;
    }

    @Override 
    public void end(boolean interrupted) {
        System.out.println("Ended");    
    }

    @Override
    public boolean isFinished() {
        return done;
    }

    @Override
    public boolean runsWhenDisabled() {return true;}
}