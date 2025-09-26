// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;

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
  public SparkMax motorIzquierdo1;
  public SparkMax motorIzquierdo2;
  public SparkMax motorExtra;

  public Robot() { //ESTO SE EJECUTA AL INICIO DEL ROBOT (CUANDO SE ENCIENDE / ACTIVA)

    //Paso 2: Inicializar los motores
    // Cada motor se inicia con la funcion [new SparkMax(numeroPuerto, tipoMotor)]
    // donde puerto es el CAN ID y tipoMotor es si es brushed o brushless
    motorDerecho1 = new SparkMax(1, MotorType.kBrushed);
    motorDerecho2 = new SparkMax(2, MotorType.kBrushed);
    motorIzquierdo1 = new SparkMax(3, MotorType.kBrushed);
    motorIzquierdo2 = new SparkMax(4, MotorType.kBrushed);

    motorExtra = new SparkMax(5, MotorType.kBrushless);
  }

  // WPI LIB METHODS
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
