package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Doctor;
import model.Patient;

public class UIMenu {
    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){
        System.out.println("Welcome to my appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do{
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                default:
                    System.out.println("Please select a correct answer");   
            }
        }while(response != 0);
    }

    private static void authUser(int usertType){
        //1 Doctor
        //2 Patient
        //--Simulando acceder a la base de datos, para validar el correo--
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro martinez", "alejandro@gmail.com"));
        doctors.add(new Doctor("Karen Sosa", "karen@gmail.com"));
        doctors.add(new Doctor("Rocio Gomez", "rocio@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Pablo Nunez", "pablo@gmail.com"));
        patients.add(new Patient("Roberto Rodriguez", "roberto@gmail.com"));
        patients.add(new Patient("Carlos Sanchez", "carlos@gmail.com"));

        boolean emailCorrect = false;
        do{
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(usertType == 1){
                for (Doctor d : doctors) {
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logeado
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            } 
            if(usertType == 2){
                for (Patient p : patients) {
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        patientLogged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while(!emailCorrect);
    }
}