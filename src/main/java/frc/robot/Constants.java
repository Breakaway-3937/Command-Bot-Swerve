package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import frc.robot.generated.TunerConstants;

public final class Constants {

  public static class Controllers {
    public static final int DRIVE_CONTROLLER = 0;
    public static final double STICK_DEADBAND = 0.1;
  }

  public static class Swerve {
    public static final double MAX_SPEED = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond);
    public static final double MAX_ANGULAR_RATE = RotationsPerSecond.of(1.25).in(RadiansPerSecond);
  }
  public static final class motors {
    public static final int MOTOR_1_ID = 12; 
    public static final int MOTOR_2_ID = 13; 
  }

}

