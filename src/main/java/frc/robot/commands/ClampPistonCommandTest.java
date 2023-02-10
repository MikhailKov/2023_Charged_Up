package frc.robot.commands;

// import java.util.Set;

// import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.Subsystem;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Robot;
// import frc.robot.subsystems.ClampPistonTest;

public class ClampPistonCommandTest extends CommandBase {
    // private final ClampPistonTest piston = null;

    public ClampPistonCommandTest(){

    }

    // public ClampPistonCommandTest(ClampPistonTest piston) {
    //     this.piston = piston;
    //     System.out.println("initialize clampPistonTestCommand"); 
    // }

    @Override 
    public void initialize() {
        // piston.toggleSolenoid();
        System.out.println("attempt clampPistonTestCommand");
    }

    @Override 
    public boolean isFinished() {return true;}

    @Override
    public void execute() {
        System.out.println("****** EXECUTIN CLAMPPISTONTEST");
    }

    @Override
    public boolean runsWhenDisabled(){
        return true;
    }

    public void end(){
        System.out.println("***** end ClampPistonCommandTest *****");
    }

    // @Override
    // public Set<Subsystem> getRequirements() {
    //     return piston;
    // }
}