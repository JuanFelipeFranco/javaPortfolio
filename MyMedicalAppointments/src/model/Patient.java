package model;

import model.User;

public class Patient extends User {
        String birthday;
        double weight;
        double height;
        String blood;
    //metodo constructor.
    public Patient(String name, String email ){
        super(name, email);
        //mas instrucciones

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    //54.5 kg string
    public String getWeight() {
        return this.weight + " Kg.";
    }
    //54.5
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + "metros";
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
    public String toString() {
        return super.toString() +" \nAge: "+birthday+ "\n Weight: "+getWeight()+ "\n Height "+getHeight()+
                " Blood: "+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Hitorial completo del paciente desde nacimiento");
    }
}
