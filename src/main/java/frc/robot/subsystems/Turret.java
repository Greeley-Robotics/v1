package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.TurretConstants;
import frc.robot.commands.turretCommands.Shoot;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Turret extends SubsystemBase {
    public final PWMSparkMax turretSparkMax1;
    public final PWMSparkMax turretSparkMax2;

    public Turret(CommandXboxController controller) {
        controller = new CommandXboxController(OperatorConstants.kDriverControllerPort);
        turretSparkMax1 = new PWMSparkMax(TurretConstants.kMotorControllerPort5);
        turretSparkMax2 = new PWMSparkMax(TurretConstants.kMotorControllerPort6);
    }

    public Command shootCommand() {
        return new Shoot(this);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
