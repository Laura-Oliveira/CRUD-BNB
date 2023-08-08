package com.app.crud;

public class UserApp
{
    private String id;
    private String type_user, type_worker;
    private String name, surname,  email, phone, password;

    public UserApp()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getType_user()
    {
        return type_user;
    }

    public void setType_user(String type_user)
    {
        this.type_user = type_user;
    }

    public String getType_worker()
    {
        return type_worker;
    }

    public void setType_worker(String type_worker)
    {
        this.type_worker = type_worker;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}

