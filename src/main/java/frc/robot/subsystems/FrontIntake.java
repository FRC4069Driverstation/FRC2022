package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Robot;
import frc.robot.Scheduler.RobotAsyncTask;

/** Front Intake Component */
public class FrontIntake {

    private static final int DRIVE_CAN = 10;
    private static final double DRIVE_MAGNITUDE = 1;

    private static final int ARTICULATE_CAN = 11;
    private static final double ARTICULATE_MAGNITUDE = 0.3;
    // Magnitude of Position
    private static final double ARTICULATE_POSITION = 50.0;

    private final CANSparkMax drive, articulate;
    private final RelativeEncoder articulateEncoder;

    private final Robot robot;

    // True/false is up/down state of intake
    private boolean articulateUp = true;

    public FrontIntake(Robot robot) {
        drive = new CANSparkMax(DRIVE_CAN, MotorType.kBrushless);
        articulate = new CANSparkMax(ARTICULATE_CAN, MotorType.kBrushless);
        articulateEncoder = articulate.getEncoder();
        this.robot = robot;
    }

    /**
     * Update the drive state of the front intake
     * 
     * @param enabled Front intake on, off
     * @param dir Reverse direction
     */
    public void drive(boolean enabled, boolean reverse) {
        if (!enabled) drive.set(0);
        else if (!reverse) drive.set(DRIVE_MAGNITUDE);
        else drive.set(-DRIVE_MAGNITUDE);
    }

    /** Raise/lower front intake */
    public void articulate() {
        // Flip stored state
        articulateUp = !articulateUp;
        // Reset
        articulateEncoder.setPosition(0);
        // Run thread
        robot.getScheduler().schedule((RobotAsyncTask) this::articulateFunc);
    }

    private void articulateFunc() {
        // Starts in desired direction
        if (articulateUp) articulate.set(ARTICULATE_MAGNITUDE);
        else articulate.set(-ARTICULATE_MAGNITUDE);

        // Locks async thread until desired pos is reached
        while ((!articulateUp && articulateEncoder.getPosition() > -ARTICULATE_POSITION) ||
                (articulateUp && articulateEncoder.getPosition() < ARTICULATE_POSITION));

        // Stops
        articulate.set(0);
    }

    /**
     * Update desired articulation, driven percentage
     *
     * @param drivenPercentage Between -1 and 1, percentage of driven power on intake/feed
     * @param encoderPos between 0 (fully retracted) and x (fully deployed)
     */
    public void update(double drivenPercentage, double encoderPos) {
        drive.set(drivenPercentage);

        //double error = encoderPos - encoder.getPosition();

        //articulate.set(error * kPArticulate);

        //Likely need to add D or Feedforward in order to compensate for gravity
    }

    public void updateRaw(double drivenPercentage, double articulatePercentage) {
        drive.set(drivenPercentage);
        articulate.set(articulatePercentage);

        //System.out.println("Articulated encoder Pos: " + encoder.getPosition());
    }
    
}