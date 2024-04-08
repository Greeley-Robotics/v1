package frc.robot.commands.driveCommands;

import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
    private final Drivetrain m_drivetrain;
    private final Supplier<Double> speedFunction, turnFunction;
    
    
    public ArcadeDrive(Drivetrain subsystem, 
                       Supplier<Double> speedFunction,
                       Supplier<Double> turnFunction) {
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        m_drivetrain = subsystem;
        addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {
        System.out.println("Arcade Drive started!");
    }

    @Override
    public void execute() {
        // Slow speed down to 60% & turning to 30% for better controllability
        double realTimeSpeed = speedFunction.get() * 0.6;
        double realTimeTurn = turnFunction.get() * 0.3;

        double leftMovement = realTimeSpeed + realTimeTurn;
        double rightMovement = realTimeSpeed - realTimeTurn;
        m_drivetrain.driveSparkMax1.set(leftMovement);
        m_drivetrain.driveSparkMax2.set(leftMovement);
        m_drivetrain.driveSparkMax3.set(-rightMovement);
        m_drivetrain.driveSparkMax4.set(-rightMovement);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("ArcadeDrive ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
