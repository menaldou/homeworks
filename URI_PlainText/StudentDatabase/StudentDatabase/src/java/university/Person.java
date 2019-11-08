/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

/**
 *
 * @author DenniseSandoval
 */
public class Person {
    private int id;
    private String name;
    private String lastname;
    private String telephone;
    private String address;

    public Person() {
    }

    public Person(int id, String name, String lastname, String telephone, String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.address = address;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nId=" + id + "\nName=" + name + "\nLastname=" + lastname + "\nTelephone=" + telephone + "\nAddress=" + address+"\n";
    }
    
}
