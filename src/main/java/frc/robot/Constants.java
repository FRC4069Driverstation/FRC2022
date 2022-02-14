package frc.robot;

/**
 * Constants that will be used across the robot code will be defined here.
 * 
 * <p>
 * For each class that requires the use of constants, include Constants in your import tag using the follwing example:
 * <p>
 * {@code import static frc.robot.Constants.*;}
 * <p>
 * Methods 
 */
public final class Constants {

    // Prevent instantiating
    private Constants() {}

    /*
    * Constants are declared as such: 
    * "public static final String EXAMPLE_NAME = "Example Value";"
    * 
    * These can be referenced across the project by simply typing the name of the constant.
    * Given that these variables will be accessible by any class that statically imports this class,
    * please make sure that the name you assign is specific and will not cause conflict.
    */

    /*
    * Gamepad
    */

    // USB IDs
    public static final int GP_1 = 0;
    public static final int GP_2 = 1;

    
    /*
    * Drivetrain
    */

    // Gear sensitivity, (2020 port)
    public static final double DT_HIGH_GEAR_SENSITIVITY = 0.35;
    public static final double DT_HIGH_GEAR_MOVING_SENSITIVITY = 0.45;
    public static final double DT_LOW_GEAR_SENSITIVITY = 0.625;

    // PID
    public static final double DT_LEFT_P = 0.6;
    public static final double DT_LEFT_I = 0.0;
    public static final double DT_LEFT_D = 0.0;

    public static final double DT_RIGHT_P = 0.6;
    public static final double DT_RIGHT_I = 0.0;
    public static final double DT_RIGHT_D = 0.0;

    // Hardware IDs, (2020 port)
    // Motors controlled by Spark Maxes
    public static final int DT_LEFT_MASTER = 4; // 2022
    public static final int DT_LEFT_SLAVE = 5; // 2022
    public static final int DT_LEFT_MASTER_ENC = 0; // A to be updated
    public static final int DT_LEFT_SLAVE_ENC = 1; // B to be updated

    public static final int DT_RIGHT_MASTER = 6; // 2022
    public static final int DT_RIGHT_SLAVE = 7; // 2022
    public static final int DT_RIGHT_MASTER_ENC = 2; // A to be updated
    public static final int DT_RIGHT_SLAVE_ENC = 3; // B to be updated

    public static final int DT_SHIFTER_FWD = 0;
    public static final int DT_SHIFTER_BCK = 1;

    public static final double DT_ARCADE_DEADBAND = 0.02;

    /*
    * Shooter
    */

    public static final int FW_FALCON_1 = 8;
    public static final int FW_FALCON_2 = 9;
    public static final int FW_ENC_TOP_A = 0;
    public static final int FW_ENC_TOP_B = 1;
    public static final int FW_ENC_BOTTOM_A = 2;
    public static final int FW_ENC_BOTTOM_B = 3;


    /*
    * Front Intake
    */

    public static final int FI_NEO_DRIVE = 10;
    public static final int FI_NEO_ARTICULATE = 11;


    /*
    * Rear Intake
    */

    public static final int RI_NEO_DRIVE = 14;


    /*
    * Pneumatics
    */

    public static final int PN_PRESSURE_SENSOR = 0;


    /*
    * Tower
    */
    public static final int TW_LEFT = 0;
    public static final int TW_RIGHT = 0;
}
