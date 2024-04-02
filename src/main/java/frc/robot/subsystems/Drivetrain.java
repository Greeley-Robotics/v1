// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.driveCommands.DriveForward;
import frc.robot.commands.driveCommands.DriveInterval;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/** Drivetrain subsystem */
public class Drivetrain extends SubsystemBase {
  public final PWMSparkMax driveSparkMax1;
  public final PWMSparkMax driveSparkMax2;
  public final PWMSparkMax driveSparkMax3;
  public final PWMSparkMax driveSparkMax4;

  public Drivetrain(CommandXboxController controller) {
    controller = new CommandXboxController(OperatorConstants.kDriverControllerPort);
    driveSparkMax1 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort1);
    driveSparkMax2 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort2);
    driveSparkMax3 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort3);
    driveSparkMax4 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort4);
  }

  /**
   * driveForwardCommand factory method
   *
   * @return driveFowardCommand
   */
  public Command driveForwardCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return new DriveForward(this); 
  }

  public Command driveIntervalCommand() {
    return new DriveInterval(this);
  }

  /**
   * Get the current value of the `a` button
   *
   * @return value of `a` button on controller
   */
  // public boolean exampleCondition() {
  //   // Query some boolean state, such as a digital sensor.
  //   if(controller.a().getAsBoolean() == true) {
  //     return true;
  //   }
  //   return false;
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
