package model;

public class User{
    protected String name;
    protected String email;

    public User(String name, String email){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (email == null || !email.contains("@") || !email.contains(".") || email.indexOf("@") >= email.lastIndexOf(".")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.name=name;
        this.email=email;
    }

    public void displayProfile(){
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}

