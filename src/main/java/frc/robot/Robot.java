// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {

// Tarea: hacer 3 codigos diferentes usando metodos .....
//diferentes para hacer que el robot se mueva............
// Van a tener 1 motor de cada lado .....................OK!

  private SparkMax leftMotor = new SparkMax(1, MotorType.kBrushed);
  private SparkMax rightMotor = new SparkMax(2, MotorType.kBrushed);
  private DifferentialDrive dDrive = new DifferentialDrive(leftMotor, rightMotor);
  private final double maxSpeed = 3.0; // m/s
  private final double maxRot = 0.2*Math.PI; // rad/s

  public Robot() {
    leftMotor.setInverted(false);
    rightMotor.setInverted(true);
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  // Metodo 1: Usando Speed y Rotation de un controller
  public void drive1(XboxController controller){
    // speed -> [-1.0, 1.0]
    double vSpeed = controller.getRightTriggerAxis();
    double brake = controller.getLeftTriggerAxis();
    double rotation = controller.getLeftX();
    double leftSpeed = vSpeed - brake + rotation;
    double rightSpeed = vSpeed - brake - rotation;
    leftSpeed = Math.max(-1, Math.min(1, leftSpeed));
    rightSpeed = Math.max(-1, Math.min(1, rightSpeed));
    leftMotor.set(leftSpeed);
    rightMotor.set(rightSpeed);
  }

  // Metodo 2: Usando la clase de WPI DifferentialDrive
  public void drive2(double speed, double rot){
    dDrive.arcadeDrive(speed, rot);
    // return :)
  }

  // Metodo 3: Usando ChassisSpeeds
  public void drive3(ChassisSpeeds speeds){
    double xspeed = speeds.vxMetersPerSecond / maxSpeed; // Normalizar a [-1.0, 1.0]  
    double zrot = speeds.omegaRadiansPerSecond / maxRot; // Normalizar a [-1.0, 1.0]  
    dDrive.arcadeDrive(xspeed, zrot);
  }
}