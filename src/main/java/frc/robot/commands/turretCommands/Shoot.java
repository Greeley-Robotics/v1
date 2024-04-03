package frc.robot.commands.turretCommands;

import frc.robot.Constants.AutonomousConstants;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class Shoot extends Command {
    private final Turret m_turret;
    private double valToSet = AutonomousConstants.kTurretThrowSpeed;
    private double seconds = AutonomousConstants.kTurretThrowDelay;

    public Shoot(Turret subsystem) {
        m_turret = subsystem;
        addRequirements(m_turret);
    }

    @Override
    public void initialize() {
        m_turret.turretSparkMax1.set(0.0);
        m_turret.turretSparkMax2.set(0.0);
    }

    @Override
    public void execute() {
        System.out.println("SHOOT COMMAND (TURRET) EXECUTING!!!");
        m_turret.turretSparkMax1.set(valToSet);
        m_turret.turretSparkMax2.set(valToSet);
        Timer.delay(seconds);
        m_turret.turretSparkMax1.set(0.0);
        m_turret.turretSparkMax2.set(0.0);
    }

    @Override
    public void end(boolean interrupted) {
        m_turret.turretSparkMax1.stopMotor();
        m_turret.turretSparkMax2.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
