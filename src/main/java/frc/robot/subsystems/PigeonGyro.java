package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

public class PigeonGyro {
    
    Pigeon2 gyro;
    double atLastReset = 0;
    public PigeonGyro(Pigeon2 gyro) {
        this.gyro = gyro;
        
        atLastReset = gyro.getYaw;
    }

    public double getCurrentHeading() {
        return gyro.getFusedHeading() - atLastReset;
    }

    public void resetHeading() {
        System.out.println("resetting");
        atLastReset = gyro.getFusedHeading();
        //testing
    }


}
