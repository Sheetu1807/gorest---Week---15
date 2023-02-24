package com.gorest.model;

public class UserPojo {

    private int ID;
    private String name;
    private String email;
    private String gender;
    private String status;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


//           "id": 598412,
//          "name": "Nanda Pandey",
//          "email": "nanda_pandey@fahey.com",
//          "gender": "male",
//          "status": "inactive"