package asd.demo.model;

import java.io.Serializable;

public class User  implements Serializable{

    private String name;
    private String email;
    private String password;
    private String phone;
    private Boolean isAdmin;

    public User() {
    }

    public User(String name, String email, String password, String phone, Boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public boolean match(String email){
        return this.email.equalsIgnoreCase(email.trim());
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
