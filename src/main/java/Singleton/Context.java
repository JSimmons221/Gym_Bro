package Singleton;

import Objects.Reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Context {
    private final static Context instance = new Context();
    private final ArrayList<String> Equipment = new ArrayList<String>();
    private final ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
    private String equip = "";
    private int idNum = 0;

    public static Context getInstance(){
        return instance;
    }

    public Context() {
        Equipment.add("Squat Rack");
        Equipment.add("Bench Press");
        Equipment.add("Pullup Bar");
        Equipment.add("Pec Fly");
        Equipment.add("Cable Row");
        Equipment.add("Lateral Pulldown");
        Equipment.add("Incline Press");
        Equipment.add("Overhead Press");
        Equipment.add("Chest Press");
        Equipment.add("Hamstring Curls");
        Equipment.add("Leg Extension");
        Equipment.add("Leg Press");
        Equipment.add("Calve Raise");
        Equipment.add("Smith Machine");
        Equipment.add("Incline Situp");
        Equipment.add("Hip Abductors");
        Equipment.add("Hip Adductors");
        Equipment.add("Preacher Curl");

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String s = Equipment.get(rand.nextInt(Equipment.size()));
            int d = rand.nextInt(4) + 5;
            int h = rand.nextInt(13) + 6;
            int min = rand.nextInt(12) * 5;

            Reservation res = new Reservation(s, 12, d, h, min, idNum++);
            Reservations.add(res);
        }

        Collections.sort(Reservations);
    }

    public ArrayList<String> getEquipment() {
        return Equipment;
    }

    public ArrayList<Reservation> getReservations() {
        return Reservations;
    }

    public void addReservation(String e, String date, String time){
        Reservation res = new Reservation(e, date, time, idNum++);
        Reservations.add(res);
        Collections.sort(Reservations);
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public void removeReservation(int id){
        for (int i = 0; i < Reservations.size(); i++) {
            Reservation res = Reservations.get(i);
            if (res.getId() == id){
                Reservations.remove(res);
            }
        }
    }

    public boolean checkReservation(String date, String time){
        Reservation res = new Reservation("", date, time, -1);
        for (Reservation r: Reservations){
            if (r.equals(res)){
                return false;
            }
        }
        return true;
    }
}