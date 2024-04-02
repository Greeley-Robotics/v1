// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driveCommands;

import frc.robot.Constants.AutonomousConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** DriveForward Command **/
public class DriveForward extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_drivetrain;
  private double valToSet = AutonomousConstants.kAutoDriveForwardSpeed;

  /**
   * DriveForward Command constructor
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForward(Drivetrain subsystem) {
    m_drivetrain = subsystem;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.driveSparkMax1.set(0.0);
    m_drivetrain.driveSparkMax2.set(0.0);
    // m_drivetrain.driveSparkMax3.set(0.0);
    // m_drivetrain.driveSparkMax4.set(0.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("DRIVE FORWARD (DRIVETRAIN) EXECUTING!!!");
    m_drivetrain.driveSparkMax1.set(valToSet);
    m_drivetrain.driveSparkMax2.set(valToSet);
    // m_drivetrain.driveSparkMax3.set(-valToSet);
    // m_drivetrain.driveSparkMax4.set(-valToSet);
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.driveSparkMax1.stopMotor();
    m_drivetrain.driveSparkMax2.stopMotor();
    // m_drivetrain.driveSparkMax3.stopMotor();
    // m_drivetrain.driveSparkMax4.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
