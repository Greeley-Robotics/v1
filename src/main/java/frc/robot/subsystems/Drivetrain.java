// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveForward;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public final PWMSparkMax sparkMax1;

  private final CommandXboxController controller;

  public Drivetrain(CommandXboxController control) {
    controller = new CommandXboxController(OperatorConstants.kDriverControllerPort);
    sparkMax1 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort1);
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

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean move() {
    // Query some boolean state, such as a digital sensor.
    if(controller.a().getAsBoolean() == true) {
      return true;
    }
    return false;
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
