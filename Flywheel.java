package org.firstinspires.ftc.teamcode;
//Importing libraries
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Flywheel extends SubsystemBase {
    // Configuring flywheels as DcMotors
    DcMotorEx RightFly;
    DcMotorEx LeftFly;
    public Flywheel(HardwareMap hmap){
        // Initializing motors and pairing them
        RightFly = hmap.get(DcMotorEx.class, "RightFly");
        LeftFly = hmap.get(DcMotorEx.class, "LeftFly");
    }
    public void launch (boolean isPressed){
        //If button is pressed, it will launch whatever is between the motors outwards
        RightFly.setPower(1);
        LeftFly.setPower(-1);
    }

}
