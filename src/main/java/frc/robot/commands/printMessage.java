package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.piston;

public class printMessage extends CommandBase {
    private piston message;
    
    public printMessage(piston aPiston) {
        this.message = aPiston;
        addRequirements(message);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        System.out.println(message.getMessage());
    }

    @Override 
    public void end(boolean interrupted) {
        System.out.println("Ended");    
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {return true;}
}