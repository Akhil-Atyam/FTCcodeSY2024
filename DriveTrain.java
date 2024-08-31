package org.firstinspires.ftc.teamcode;
//Importing libraries
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain extends SubsystemBase {
    //Configuration of motors as Dc motors
    DcMotorEx FrontR;
    DcMotorEx BackR;
    DcMotorEx FrontL;
    DcMotorEx BackL;
    public  DriveTrain(HardwareMap hmap){
        //Initialization and pairing motors on hub
        FrontR = hmap.get(DcMotorEx.class, "FrontR");
        FrontL = hmap.get(DcMotorEx.class, "FrontL");
        BackR = hmap.get(DcMotorEx.class, "BackR");
        BackL = hmap.get(DcMotorEx.class, "BackL");
    }
    public void drive(double x, double y, double rx){
        //To get a common ratio so no weird movements because SDK cutoff, this makes sure you get the most accurate output.
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        // Set up variables for the power. y+x, so if y and x is 1 it adds to 2, but SDK cutoff makes it 1 with full power divided by denominator.
        double FrontLP = (y + x + rx) / denominator;
        double BackLP = (y - x + rx) / denominator;
        double FrontRP = (y - x - rx) / denominator;
        double BackRP = (y + x - rx) / denominator;
        //Set power to wheels using previous values
        FrontL.setPower(FrontLP);
        BackL.setPower(BackLP);
        FrontR.setPower(FrontRP);
        BackR.setPower(BackRP);

    }
}
