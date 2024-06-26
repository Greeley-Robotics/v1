// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.driveCommands.DriveForward;
import frc.robot.commands.driveCommands.DriveInterval;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** Drivetrain subsystem */
public class Drivetrain extends SubsystemBase {
  public final PWMSparkMax sparkMax1;
  public final PWMSparkMax sparkMax2;
  public final PWMSparkMax sparkMax3;
  public final PWMSparkMax sparkMax4;
  private DifferentialDrive m_robotDrive;

  // Rename to sparkMaxLeftLeader, sparkMaxLeftFollower... for follower and inverted code

  public Drivetrain(Joystick controller) {
    controller = new Joystick(OperatorConstants.kDriverControllerPort);
    sparkMax1 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort0);
    sparkMax2 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort1);
    sparkMax3 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort2);
    sparkMax4 = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort3);

    // Follower and Inverted Code
    // sparkMax1.addFollower(sparkMax2);
    // sparkMax3.addFollower(sparkMax4);

    // sparkMax3.setInverted(true);

    // m_robotDrive = new DifferentialDrive(sparkMax1::set, sparkMax3::set);
  }

  /**
   * driveForwardCommand factory method
   *
   * @return driveFowardCommand
   */
  public Command driveForwardCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem
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

  // Hardware should only be accessed in subsystems
  // Switch to calling this after opposite direction problem fixed
  // public void setMotors(double left, double right) {
  //   sparkMax1.set(left);
  //   sparkMax3.set(-right);
  // }
}
