/*package frc.robot.commands;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClampPiston extends CommandBase implements Runnable {
	Solenoid piston;
	int channel;

	public ClampPiston(int channel) {
		super();
		
		piston = new Solenoid(PneumaticsModuleType.REVPH, channel);
		this.channel = channel;
    }

    public void initialize() {
        execute();
    }
    
    public void execute() {
        toggle();
    }

    public void end(boolean interrupted) {
        if(!getToggled()) {return;}
        toggle();    
    }

    public void toggle() {
        piston.toggle();
        SmartDashboard.putBoolean("Piston Toggled", getToggled());
        System.out.println("Toggled Piston");
    }

    private boolean getToggled() {
        return piston.get();
    }
}
*/