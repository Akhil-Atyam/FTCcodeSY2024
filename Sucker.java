package org.firstinspires.ftc.teamcode;
//Importing libraries
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Sucker extends SubsystemBase {
    //Configuring sucker as a dc motor
    DcMotorEx sucker;
    public Sucker(HardwareMap hmap){
        //Initializing sucker and pairing it to the hub
        sucker = hmap.get(DcMotorEx.class,"Sucker");
    }
    public void suck(){
        //Sucking the rings in by motor grabbing it and friction.
        sucker.setPower(1);

    }
    public void release(){
        //Releasing anything within the sucker's domain
        sucker.setPower(-1);
    }

    public void stop(){
        //Stops sucking anything
        sucker.setPower(0);
    }
}
