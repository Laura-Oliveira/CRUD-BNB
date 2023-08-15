package com.app.crud.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Company extends RealmObject
{
    @PrimaryKey
    private long id;
    private int razaoSocial, cnpj;
    private String name;
    private String email;
    private String neigbornhood;
    private String city;
    private String typeAdress;
    private String number;
    private String phone;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    private String cep;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(int razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
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

    public String getNeigbornhood() {
        return neigbornhood;
    }

    public void setNeigbornhood(String neigbornhood) {
        this.neigbornhood = neigbornhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTypeAdress() {
        return typeAdress;
    }

    public void setTypeAdress(String typeAdress) {
        this.typeAdress = typeAdress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    private String adress;
    private String extraInfo;
    private String uf;



}
