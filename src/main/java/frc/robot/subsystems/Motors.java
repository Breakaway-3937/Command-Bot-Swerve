package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.networktables.StringEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motors extends SubsystemBase {
  private SparkMax Motor1;
  private SparkMax Motor2;
  private SparkMax Motor3;
  private SparkMax Motor4;

  private String motorType1 = "Brushed";
  private String motorType2 = "Brushed";
  private String motorType3 = "Brushed";
  private String motorType4 = "Brushed";

  private final DoubleEntry motor1SpeedEntry;
  private final DoubleEntry motor2SpeedEntry;
  private final DoubleEntry motor3SpeedEntry;
  private final DoubleEntry motor4SpeedEntry;
  private final StringEntry motor1TypeEntry;
  private final StringEntry motor2TypeEntry;
  private final StringEntry motor3TypeEntry;
  private final StringEntry motor4TypeEntry;
  Double speed1 = 0.0;
  Double speed2 = 0.0;
  Double speed3 = 0.0;
  Double speed4 = 0.0;

  public Motors() {
    NetworkTable motorsTable = NetworkTableInstance.getDefault().getTable("Motors");
    
    motor1SpeedEntry = motorsTable.getDoubleTopic("Motor1Speed").getEntry(0.0);
    motor2SpeedEntry = motorsTable.getDoubleTopic("Motor2Speed").getEntry(0.0);
    motor3SpeedEntry = motorsTable.getDoubleTopic("Motor3Speed").getEntry(0.0);
    motor4SpeedEntry = motorsTable.getDoubleTopic("Motor4Speed").getEntry(0.0);
    motor1TypeEntry = motorsTable.getStringTopic("Motor1Type").getEntry("Brushed");
    motor2TypeEntry = motorsTable.getStringTopic("Motor2Type").getEntry("Brushed");
    motor3TypeEntry = motorsTable.getStringTopic("Motor3Type").getEntry("Brushed");
    motor4TypeEntry = motorsTable.getStringTopic("Motor4Type").getEntry("Brushed");
    

    motor1TypeEntry.set("Brushed");
    motor2TypeEntry.set("Brushed");
    motor3TypeEntry.set("Brushed");
    motor4TypeEntry.set("Brushed");
    Motor1 = new SparkMax(Constants.motors.MOTOR_1_ID, MotorType.kBrushed);
    Motor2 = new SparkMax(Constants.motors.MOTOR_2_ID, MotorType.kBrushed);
    Motor3 = new SparkMax(Constants.motors.MOTOR_3_ID, MotorType.kBrushed);
    Motor4 = new SparkMax(Constants.motors.MOTOR_4_ID, MotorType.kBrushed);
  }

  @Override
  public void periodic() {
    String chosen1 = motor1TypeEntry.get();
    String chosen2 = motor2TypeEntry.get();
    String chosen3 = motor3TypeEntry.get();
    String chosen4 = motor4TypeEntry.get();

    speed1 = getMotor1Speed();
    speed2 = getMotor2Speed();
    speed3 = getMotor3Speed();
    speed4 = getMotor4Speed();

    if (!chosen1.equals(motorType1)) {
      Motor1.close();
      MotorType type1;
      if (chosen1.equals("Brushless")) {
        type1 = MotorType.kBrushless;
      } else {
        type1 = MotorType.kBrushed;
      }
      Motor1 = new SparkMax(Constants.motors.MOTOR_1_ID, type1);
      motorType1 = chosen1;
    }

    if (!chosen2.equals(motorType2)) {
      Motor2.close();
      MotorType type2;
      if (chosen2.equals("Brushless")) {
        type2 = MotorType.kBrushless;
      } else {
        type2 = MotorType.kBrushed;
      }
      Motor2 = new SparkMax(Constants.motors.MOTOR_2_ID, type2);
      motorType2 = chosen2;
    }

    if (!chosen3.equals(motorType3)) {
      Motor3.close();
      MotorType type3;
      if (chosen3.equals("Brushless")) {
        type3 = MotorType.kBrushless;
      } else {
        type3 = MotorType.kBrushed;
      }
      Motor3 = new SparkMax(Constants.motors.MOTOR_3_ID, type3);
      motorType3 = chosen3;
    }

    if (!chosen4.equals(motorType4)) {
      Motor4.close();
      MotorType type4;
      if (chosen4.equals("Brushless")) {
        type4 = MotorType.kBrushless;
      } else {
        type4 = MotorType.kBrushed;
      }
      Motor4 = new SparkMax(Constants.motors.MOTOR_4_ID, type4);
      motorType4 = chosen4;
    }

    Motor1.set(motor1SpeedEntry.get());
    Motor2.set(motor2SpeedEntry.get());
    Motor3.set(motor3SpeedEntry.get());
    Motor4.set(motor4SpeedEntry.get());
  }

  public Command setMotor1Speed() {
    return runOnce(() -> motor1SpeedEntry.set(speed1));
  }

  public Command setMotor2Speed() {
    return runOnce(() -> motor2SpeedEntry.set(speed2));
  }

  public Command setMotor3Speed() {
    return runOnce(() -> motor3SpeedEntry.set(speed3));
  }

  public Command setMotor4Speed() {
    return runOnce(() -> motor4SpeedEntry.set(speed4));
  }


  public double getMotor1Speed() {
    return motor1SpeedEntry.get();
  }

  public double getMotor2Speed() {
    return motor2SpeedEntry.get();
  }

  public double getMotor3Speed() {
    return motor3SpeedEntry.get();
  }

  public double getMotor4Speed() {
    return motor3SpeedEntry.get();
  }
}