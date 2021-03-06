
// getPosition(); 
// SendLevelCommand() button for level 1,2,3 takes enum values, figures out num of rotations = 1
// ElvSubSystem() Set height to number of rotations, check if rotations are close enough (close enuogh to what?), and if not, go again, return boolean true if close, false if it had to move
package org.usfirst.frc.team3786.robot.commands.elevator;

import org.usfirst.frc.team3786.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorSendCommand extends Command {
    
    ElevatorSubsystem.Levels levels;
    private double rotations;
    private boolean done;

    public ElevatorSendCommand(ElevatorSubsystem.Levels gotoLevel) {
        requires(ElevatorSubsystem.getInstance());
        levels = gotoLevel;
    }

    @Override
    protected void initialize() {
        done = false;
        System.out.println("[!] CURRENT LEVEL IS: " + levels);
    }

    @Override
    protected void execute() {
        rotations = ElevatorSubsystem.getInstance().getRotation();
        //System.out.println("[!] NUMBER OF ROTATIONS: " + rotations);
        if(rotations >= 1.0) {
            done = true;
        }

    }

    @Override
    protected boolean isFinished() {
        return done;
    }

    @Override
    protected void end() {
        ElevatorSubsystem.getInstance().setElevatorSpeed(0.0);        
    }

    @Override
    protected void interrupted() {
        
    }
}
