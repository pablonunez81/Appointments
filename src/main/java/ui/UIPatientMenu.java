package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import model.Doctor;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged);
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;

                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    break;
            }
        } while (response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date: ");
            // mostrar las fechas de los doctores que dejaron fechas disponibles
            // Map 1) Numeración de la lista de fechas
            // Indice fecha seleccionada
            // [doctors]
            // 1.- doctor1
            // - 1 fecha1
            // - 2 fecha2
            // 2.- doctor2
            // 3.- doctor3
            // Map < < n cita > doctorAppointments>
            TreeMap<Integer, TreeMap<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            // recorrer doctores que tienen cita, y extraer sus citas
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                /**
                 * Obtenemos las citas de un determinado doctor(i)
                 */
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments
                        .get(i).getAvailableAppointment();

                /**
                 * Lista de doctores que tienen agenda disponible
                 */
                TreeMap<Integer, Doctor> doctorAppointments = new TreeMap<>();

                /**
                 * Recorro las citas disponibles de un doctor(i)
                 */
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    /**
                     * Mostrar la lista de fechas disponibles
                     */
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    /**
                     * añade cada cita del doctor(i) en doctorAppointments
                     */
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    /**
                     * añadir una agenda disponible de un doctor en el objeto TreeMaps doctors,
                     * enumerado por k que cambia por cada cita por cada doctor
                     */
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            // Manejar las respuestas.
            // Debo detectar a que Doctor corresponde la fecha que seleccionó
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            //prueba
            System.out.println("opción seleccionada existe? " + doctors.containsKey(responseDateSelected));
            TreeMap<Integer, Doctor> docPrueba = doctors.get(responseDateSelected);
            

            // Obtenemos la respuesta seleccionada
            TreeMap<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);

            // indice de la fecha
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            //prueba
            //doctorAvailableSelected;

            /**
             * Verificar código. Con entrySet se recorre un Map
             */
            int l = 0;
            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                l++;
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
                if(l==responseDateSelected)
                    break;
            }

            //Confirmamos la fecha hora seleccionada
            System.out.println(doctorSelected.getName() + 
                ". Date: " +
                doctorSelected.getAvailableAppointment().get(indexDate).getDate() + 
                ". Time: " + 
                doctorSelected.getAvailableAppointment().get(indexDate).getTime());
            System.out.println("Confirm your appointment: \n1. Yes \n2. Change data");

            response = Integer.valueOf(sc.nextLine());

            if(response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                    doctorSelected, 
                    doctorSelected.getAvailableAppointment().get(indexDate).getDate(null), 
                    doctorSelected.getAvailableAppointment().get(indexDate).getTime()
                    );
                showPatientMenu();    
            }
        } while (response != 0);
    }
    
    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if(UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Dont't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i+ 1;
                System.out.println(j + ". " + 
                    "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() + 
                    " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() + 
                    "\n doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor()
                );
            }
            System.out.println("0. Return");
        } while (response!=0);
    }
}
