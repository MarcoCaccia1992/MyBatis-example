package com.mybatisexample.entity;

public class UsersEntity {

    private Integer id_user;
    private String name_user;
    private String surname_user;
    private String email_user;

    public UsersEntity(){

    }

    public UsersEntity(Integer id_user, String name_user, String surname_user, String email_user) {
        this.id_user = id_user;
        this.name_user = name_user;
        this.surname_user = surname_user;
        this.email_user = email_user;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getSurname_user() {
        return surname_user;
    }

    public void setSurname_user(String surname_user) {
        this.surname_user = surname_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id_user=" + id_user +
                ", name_user='" + name_user + '\'' +
                ", surname_user='" + surname_user + '\'' +
                ", email_user='" + email_user + '\'' +
                '}';
    }
}
