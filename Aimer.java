package org.firstinspires.ftc.teamcode;
//Importing libraries
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Aimer extends SubsystemBase {
    //Configuring Aim as a servo.
    ServoEx Aim;
    public Aimer(HardwareMap hmap){
        //Initialization and servo limits for the servo.
        Aim = new SimpleServo(hmap, "Aimer", -40, 40);
    }
    public void setAim(double x){
        //x is the joystick value (1 is up -1 is down) which is multiplied by 40 to get the degree value
        x=x*40;
        //Set position of servo
        Aim.setPosition(x);
    }

}
