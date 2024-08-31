package org.firstinspires.ftc.teamcode;
//Importing libraries
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw extends SubsystemBase {


    //Configuring claws as servos
    ServoEx RClaw;
    ServoEx LClaw;
    public Claw(HardwareMap hmap){
        //Initialization, Setting min and max degree values along with pairing motors
        RClaw = new SimpleServo(hmap,"RClaw",-90,90);
        LClaw = new SimpleServo(hmap,"LClaw",-90,90);

    }
    public void grab(){
        // Setting position to grab something (0 is grab as everything is gripped)
        RClaw.setPosition(0);
        LClaw.setPosition(0);
    }
    public void release(){
        // Setting position to 90 degrees away from gripped to release
        RClaw.setPosition(90);
        LClaw.setPosition(-90);
    }

}
