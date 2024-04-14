package frc.robot.commands.driveCommands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveInterval extends Command {
    private final Drivetrain m_drivetrain;
    
    public DriveInterval(Drivetrain sub_sys) {
        m_drivetrain = sub_sys;
        addRequirements(sub_sys);
        m_drivetrain.sparkMax1.set(0.0);
    }

    


    public void initialize() {
        m_drivetrain.sparkMax1.set(0.0);
    }

    public void execute() {
        m_drivetrain.sparkMax1.set(0.5);
    }
    public void end(boolean interrupted) {
        m_drivetrain.sparkMax1.stopMotor();
    }

     public boolean isFinished() {
    return false;
  }

}
