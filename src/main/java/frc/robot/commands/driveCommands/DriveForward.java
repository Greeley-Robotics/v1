// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driveCommands;

import static frc.robot.Constants.DrivetrainConstants;
import static frc.robot.Constants.AutonomousConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
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
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.sparkMax1.set(0.0);
    m_drivetrain.sparkMax2.set(0.0);
    m_drivetrain.sparkMax3.set(0.0);
    m_drivetrain.sparkMax4.set(0.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("EXECUTING!!!");
    m_drivetrain.sparkMax1.set(valToSet);
    m_drivetrain.sparkMax2.set(valToSet);
    m_drivetrain.sparkMax3.set(valToSet);
    m_drivetrain.sparkMax4.set(valToSet);
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.sparkMax1.stopMotor();
    m_drivetrain.sparkMax2.stopMotor();
    m_drivetrain.sparkMax3.stopMotor();
    m_drivetrain.sparkMax4.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
