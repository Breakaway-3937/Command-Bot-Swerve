// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.Utils;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import gg.questnav.questnav.QuestNav;
import gg.questnav.questnav.PoseFrame;
import frc.robot.subsystems.Swerve;

public class QuestNavSubsystem extends SubsystemBase {

  public QuestNav questNav = new QuestNav();
  private Transform3d ROBOT_TO_QUEST = new Transform3d(0.27, 0.0, 0.0, new Rotation3d());
  private Swerve s_Swerve;
  
  public QuestNavSubsystem(Swerve s_Swerve) {
    this.s_Swerve = s_Swerve;
  }

  public void setQuestNavPose(Pose2d pose) {
    // Convert 2D pose to 3D
    Pose3d robotPose3d = new Pose3d(pose);
    // Transform to Quest pose
    Pose3d questPose = robotPose3d.transformBy(ROBOT_TO_QUEST);
    questNav.setPose(questPose);
  }

  public Pose2d getPose() {
    PoseFrame[] poseFrames = questNav.getAllUnreadPoseFrames();
    
    if (poseFrames.length > 0) {
      // Get the most recent Quest pose
      Pose3d questPose = poseFrames[poseFrames.length - 1].questPose3d();
      // Transform to robot pose
      Pose3d robotPose = questPose.transformBy(ROBOT_TO_QUEST.inverse());
      return robotPose.toPose2d();
    }
    
    return new Pose2d(); // Return origin if no data available
  }

  public void updateVisionMeasurement() {
    Matrix<N3, N1> QUESTNAV_STD_DEVS = VecBuilder.fill(0.02, 0.02, 0.035); //The suggested Standard Deviations for QuestNav

    if (questNav.isConnected()) {
      // Get the latest pose data frames from the Quest
      PoseFrame[] questFrames = questNav.getAllUnreadPoseFrames();

      // Loop over the pose data frames and send them to the pose estimator
      for (PoseFrame questFrame : questFrames) {
        // Make sure the Quest was tracking the pose for this frame
        if (questFrame.isTracking()) {
          // Get the pose of the Quest
          Pose3d questPose = questFrame.questPose3d();
          // Get timestamp for when the data was sent
          double timestamp = questFrame.dataTimestamp();

          // Transform by the mount pose to get your robot pose
          Pose3d robotPose = questPose.transformBy(ROBOT_TO_QUEST.inverse());

          // Convert FPGA timestamp to CTRE's time domain using Phoenix 6 utility
          double ctreTimestamp = Utils.fpgaToCurrentTime(timestamp);

          // Add the measurement to our estimator
          s_Swerve.addVisionMeasurement(robotPose.toPose2d(), ctreTimestamp, QUESTNAV_STD_DEVS);
        }
      }
    }
  }

  @Override
  public void periodic() {
    questNav.commandPeriodic(); 
    updateVisionMeasurement();
  }
}