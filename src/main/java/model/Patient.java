package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    /**
     * Guardar las citas de un paciente
     */
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();


    
    public Patient(String name, String email) {
        super(name, email);
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", email: " + getEmail();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public void ShowDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo desde nacimiento");
    }

    /**
     * Retorna la lista de agendas Paciente x Doctor, basada en la clase AppointmentDoctor
     * @return ArrayList<AppointmentDoctor>
     */
    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        /**
         * Ejecutar el agendamiento
         */
        appointmentDoctor.schedule(date, time);
        /**
         * Agregar el nuevo objeto appointmentDoctor a la lista. 
         * Sería una lista de agendas con doctores que tendría este paciente
         */
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    
    
}
