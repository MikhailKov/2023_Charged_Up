public class RobotArmCommand extends CommandBase{
    private final RobotArm robotArm = new RobotArm();
    private boolean goUp;
    public RobotArmCommand(RobotArm robotArm, boolean goUp) {
        this.robotArm = robotArm;
        this.goUp = goUp;
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