package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    // Atributos
    private String speciality;
    /**
     * Lista de citas disponibles
     */
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    /**
     * Constructor
     * 
     * @param name
     * @param email
     */
    public Doctor(String name, String email) {
        super(name, email);
        // this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", email: " + getEmail();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    

    /**
     * Añade Citas disponibles para el doctor
     * 
     * @param date
     * @param time
     */
    public void addAvailableAppointment(String date, String time) {

        availableAppointments.add(new AvailableAppointment(date, time));
    }

    /**
     * Retorna la lista de citas disponibles
     * @return ArrayList<AvailableAppointment>
     */
    public ArrayList<AvailableAppointment> getAvailableAppointment() {
        return availableAppointments;
    }

    // ----------Clase anidada---------------

    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate(){
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    @Override
    public void ShowDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerología");

    }



}
