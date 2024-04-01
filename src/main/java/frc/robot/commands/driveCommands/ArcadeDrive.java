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
        double realTimeSpeed = speedFunction.get();
        double realTimeTurn = turnFunction.get();

        double leftMovement = realTimeSpeed + realTimeTurn;
        double rightMovement = realTimeSpeed - realTimeTurn;
        m_drivetrain.sparkMax1.set(leftMovement);
        m_drivetrain.sparkMax2.set(leftMovement);
        m_drivetrain.sparkMax3.set(rightMovement);
        m_drivetrain.sparkMax4.set(rightMovement);
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
