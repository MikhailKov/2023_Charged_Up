package frc.robot.subsystems;

import frc.robot.subsystems.*;

public class AprilTagPresets extends SubsystemBase{
    public int tag;
    private boolean cone;
    public AprilTagPresets(int tag, boolean cone){
        this.tag = tag;
        this.cone = cone;
    }

    @Override
    public void initialize()
    {
        if(cone) {
            switch(tag) {
                case 0:
                    
                    break;
                case 1:
                    
                    break;
                default: 

                    break;
            }
        }
        else {
            switch(tag) {
                case 0:
                    
                    break;
                case 1:

                    break;
                default: 

                    break;
            }
        }
    }
}