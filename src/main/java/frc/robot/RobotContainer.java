package frc.robot;

import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Motors;
import frc.robot.generated.TunerConstants;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private final Swerve s_Swerve = TunerConstants.createDrivetrain();
  private final Motors s_Motors = new Motors();
  private double translationMultiplier = 1;
  private double rotationMultiplier = 1;

  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
    .withDeadband(Constants.Swerve.MAX_SPEED * Constants.Controllers.STICK_DEADBAND)
    .withRotationalDeadband(Constants.Swerve.MAX_ANGULAR_RATE * Constants.Controllers.STICK_DEADBAND) 
    .withDriveRequestType(DriveRequestType.OpenLoopVoltage);

  private final CommandXboxController driveController = new CommandXboxController(Constants.Controllers.DRIVE_CONTROLLER);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    s_Swerve.setDefaultCommand(
      s_Swerve.applyRequest(() ->
        drive.withVelocityX(driveController.getLeftX() * translationMultiplier * Constants.Swerve.MAX_SPEED)
          .withVelocityY(driveController.getLeftY() * translationMultiplier * Constants.Swerve.MAX_SPEED) 
          .withRotationalRate(driveController.getRightX() * rotationMultiplier * Constants.Swerve.MAX_ANGULAR_RATE)
      )
    );

    driveController.rightBumper().onTrue(Commands.runOnce(() -> { s_Swerve.seedFieldCentric(); }));
    driveController.a().onTrue(s_Motors.setMotor1Speed());
    driveController.b().onTrue(s_Motors.setMotor2Speed());
    driveController.x().onTrue(s_Motors.setMotor3Speed());
    driveController.y().onTrue(s_Motors.setMotor4Speed());
  }
}
