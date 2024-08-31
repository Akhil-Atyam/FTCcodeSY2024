package org.firstinspires.ftc.teamcode;
//Importing libraries
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmJoint extends SubsystemBase{
    //Configuring joint as a DcMotor
    DcMotorEx joint;

    public ArmJoint(HardwareMap hmap){
        //Initializing joint and naming it within controller
        joint = hmap.get(DcMotorEx.class,"joint");
    }
    public void moveUp(){
        //Setting motor power to 1 moves the arm up on the robot.
        joint.setPower(1);

    }
    public void moveDown(){
        //Setting motor power to -1 moves the arm down
        joint.setPower(-1);
    }
    public void stop(){
        //Setting motor power to 0 just doesn't add any input / nullify any previous input.
        joint.setPower(0);
    }
    public double getPos(){
        //Returns the current position value of the motor, used for PID motor holding.
        return joint.getCurrentPosition();
    }
}
