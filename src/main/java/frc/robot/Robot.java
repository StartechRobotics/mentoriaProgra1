// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Radians;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {

  //LO QUE ESTA AFUERA ES UNIVERSAL (EXISTE DESDE ANTES DE ENCENDER EL ROBOT)
  //Paso 1: Crear los motores
  // Creando una variable (de tipo sparkmax) para cada motor
  
  public SparkMax motorDerecho1;
  public SparkMax motorDerecho2;
  public SparkMaxConfig RightConfig1;
  public SparkMaxConfig RightConfig2;

  public SparkMax motorIzquierdo1;
  public SparkMax motorIzquierdo2;
  public SparkMaxConfig LeftConfig2;

  public XboxController control = new XboxController(Constants.kDriverControllerPort);

  public Robot() { //ESTO SE EJECUTA AL INICIO DEL ROBOT (CUANDO SE ENCIENDE / ACTIVA)

    //Paso 2: Inicializar los motores
    // Cada motor se inicia con la funcion [new SparkMax(numeroPuerto, tipoMotor)]
    // donde puerto es el CAN ID y tipoMotor es si es brushed o brushless
    motorDerecho1 = new SparkMax(Constants.kRight1, MotorType.kBrushed);
    motorDerecho2 = new SparkMax(Constants.kRight2, MotorType.kBrushed);
    RightConfig1 = new SparkMaxConfig();
    RightConfig2 = new SparkMaxConfig();
    RightConfig1.inverted(true);
    RightConfig2.follow(motorDerecho1);
    motorDerecho1.configure(RightConfig1, null, null);
    motorDerecho2.configure(RightConfig2, null, null);

    motorIzquierdo1 = new SparkMax(Constants.kLeft1, MotorType.kBrushed);
    motorIzquierdo2 = new SparkMax(Constants.kLeft2, MotorType.kBrushed);
    LeftConfig2 = new SparkMaxConfig();
    LeftConfig2.follow(motorIzquierdo1);
    motorIzquierdo2.configure(LeftConfig2, null, null);

  }
  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drive(new ChassisSpeeds(
      -control.getLeftY()*Constants.kMeterSecondProportion, //SpeedX(Y) = -Y*kMeterProportion
      0.0,
      control.getRightX() * Constants.kRadProportion));
  }

  // Escribir un metodo Drive que tome como parametros la velocidad V y velocidad angular W
  public void drive(ChassisSpeeds speeds){
    double V = speeds.vxMetersPerSecond;
    double W = speeds.omegaRadiansPerSecond;
    double speedR = V+W*180/Math.PI;
    double speedL = V-W*180/Math.PI; 
    motorDerecho1.set(speedR);
    motorIzquierdo1.set(speedL); 
  }

}
