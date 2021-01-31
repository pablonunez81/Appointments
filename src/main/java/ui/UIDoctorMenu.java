package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Doctor;

public class UIDoctorMenu {

    /**
     * Lista de doctores que tienen disponible agenda
     * @return ArrayList<Doctor>
     */
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome: " + UIMenu.doctorLogged);
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My scheduled appointment");
            System.out.println("0.   Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    showDoctorMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                default:
                    break;
            }
        } while (response != 0);
    }

    /**
     * Mostramos los meses disponibles. Solo enero a marzo en este caso
     */
    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i+1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }

            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response > 0 && response < 4){
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected-1]);
                
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("You date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if(responseDate == 2){
                    continue;
                }

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00] ");
                    time = sc.nextLine();
                    System.out.println("Your time is: " +time + "\n1. Correct\n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                } while (responseTime == 2);

                /**
                 * Añadimos una cita disponible para el doctor logeado
                 */
                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                /**
                 * Añadimos este doctor a la lista de doctores que podrían tener cita
                 */
                checkDoctorAvailableAppointment(UIMenu.doctorLogged);
            }else if(response == 0){
                showDoctorMenu();
            }

        } while (response != 0);
    }

    /**
     * Creamos una lista de doctores disponibles. Para ello, 
     * Se verifica de que el doctor tiene al menos una cita disponible, y
     * si no existe previamente en la lista, lo añade
     */
    private static void checkDoctorAvailableAppointment(Doctor doctor){
        if(doctor.getAvailableAppointment().size() > 0 
        && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }

    private static void showDoctorMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if(UIMenu.doctorLogged.getAvailableAppointment().size() == 0){
                System.out.println("Dont't have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.doctorLogged.getAvailableAppointment().size(); i++) {
                System.out.println("Date: " + UIMenu.doctorLogged.getAvailableAppointment().get(i).getDate() +
                    ", Time: " + UIMenu.doctorLogged.getAvailableAppointment().get(i).getTime());
            }
        } while (response!=0);
    }
}
