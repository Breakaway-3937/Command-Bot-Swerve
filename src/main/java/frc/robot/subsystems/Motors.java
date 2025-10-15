// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motors extends SubsystemBase {
  private final TalonFX Motor1, Motor2;

  


  public Motors() {
    Motor1 = new TalonFX(Constants.motors.MOTOR_1_ID);
    Motor2 = new TalonFX(Constants.motors.MOTOR_2_ID);
  }

  public void runArm(double speed){ 
    Motor1.set(speed);
}

public void runLeg(double speed){ 
  Motor2.set(speed);
}

 public Command runArm() {
 return new InstantCommand(() -> runArm(1));
 }

 public Command runArmBack() {
  return new InstantCommand(() -> runArm(-1));
  }

 public Command runArmNo() {
  return new InstantCommand(() -> runArm(0));
  }

 public Command runLeg() {
  return new InstantCommand(() -> runLeg(1));
  }

  public Command runLegBack() {
    return new InstantCommand(() -> runLeg(-1));
    }


public Command runLegNo() {
  return new InstantCommand(() -> runLeg(0));
  }
}

