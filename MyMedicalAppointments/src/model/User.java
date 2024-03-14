package model;

public abstract class User {
    private int id;
    private String name;
    private String email;
    private String addres;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length()>8){
            System.out.println("El numero telefonico debe tener 8 digitos");
        }else if (phoneNumber.length()==8 ){
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString () {
        return "model.User: "+name+" Email: "+email+ "\n address: "+addres+ " Phone:"+phoneNumber;
    }
    //metodo que tenga comportamiento que herede paciente, nurse y doctor
    public abstract void showDataUser();

}
