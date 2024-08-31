//Importing libraries
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//Creating a TeleOp
@TeleOp(name = "Run Robot")

public class RunRobot extends LinearOpMode {
    //Declaration of everything and importing all the types of motors
    ArmJoint joint;
    Claw claw;
    DriveTrain driver;
    Sucker sucker;
    Aimer aimer;
    Flywheel flywheel;
    public void runOpMode(){
        //Initialization of all the motors
        driver = new DriveTrain(hardwareMap);
        joint = new ArmJoint(hardwareMap);
        claw = new Claw(hardwareMap);
        sucker = new Sucker(hardwareMap);
        aimer = new Aimer(hardwareMap);
        flywheel = new Flywheel(hardwareMap);
        //Actual code for running robot.
        waitForStart();
        //Break the loop using isStopRequested
        if (isStopRequested()) return;
        //Run loop
        while (opModeIsActive()){
            //Moves launcher up and down based off dpad values (Up, Down)
            if (gamepad1.dpad_down) {
                joint.moveDown();
            } else if(gamepad1.dpad_up){
                joint.moveUp();
            }else {
                joint.stop();
            }
            //Inhale objects such as rings into a feeder by using a motor (A for inhale B for exhale)
            if (gamepad1.a){
                sucker.suck();
            } else if (gamepad1.b){
                sucker.release();
            } else {
                sucker.stop();
            }
            //Grab objects and release them using servos in a claw (X to grab)
            if (gamepad1.x){
                claw.grab();
            }else {
                claw.release();
            }

            //Based off stick values, move using Mecanum omnidirectional.
            // Left stick controls movement, right stick controls rotation.
            driver.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
            //Move aim based off y vals (part of launcher)
            aimer.setAim(gamepad1.right_stick_y);
            //Flywheel to launch anything put in it when y is pressed
            flywheel.launch(gamepad1.y);
        }

    }
}
