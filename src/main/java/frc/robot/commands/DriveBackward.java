// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.DrivetrainConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;

/** DriveForward Command **/
public class DriveBackward extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain m_subsystem;
  private double valToSet;

  /**
   * DriveForward Command constructor
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveBackward(Drivetrain subsystem) {
    m_subsystem = subsystem;
    valToSet = -0.5;
    addRequirements(subsystem);
    System.out.println("a button was pressed!");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.sparkMax1.set(0.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.println("EXECUTING!!!");
    m_subsystem.sparkMax1.set(valToSet);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.sparkMax1.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
