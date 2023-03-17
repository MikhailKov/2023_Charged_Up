//Works on 2023 Bot

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeMovement;

public class SpeedUp extends CommandBase{
    //(State: Factor) 0: 1, 1: .65, 2: .45
    private boolean slowDown;

    public SpeedUp(boolean slowDown)
    {
        this.slowDown = slowDown;
    }

    @Override
    public void initialize()
    {
        if(slowDown) {
            switch(ArcadeMovement.state) {
                case 0:
                    ArcadeMovement.scalar = .65;
                    ArcadeMovement.state++;
                    break;
                case 1:
                    ArcadeMovement.scalar = .45;
                    ArcadeMovement.state++;
                    break;
                default: 
                    break;
            }
        }
        else {
            switch(ArcadeMovement.state) {
                case 2:
                    ArcadeMovement.scalar = .65;
                    ArcadeMovement.state--;
                    break;
                case 1:
                    ArcadeMovement.scalar = 1;
                    ArcadeMovement.state--;
                    break;
                default: 
                    break;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }

    
}
