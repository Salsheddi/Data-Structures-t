//import java.util.Scanner;  ليه؟

import java.util.LinkedList;

import org.w3c.dom.events.Event;

public class Contact implements Comparable<Contact> {

private String name;
private String phoneNumber;
private String emailAddress;
private String address;
private String birthday;
private String notes;
LinkedList<Event> events ;

public Contact(String name, String phoneNumber, String emailAddress, String address, String birthday,
String notes) {
this.name = name;
this.phoneNumber = phoneNumber;
this.emailAddress = emailAddress;
this.address = address;
this.birthday = birthday;
this.notes = notes;
}
  
public Contact(Contact c){ //copy cons ,with insert in LL
this.name = c.name;
this.phoneNumber = c.phoneNumber;
this.emailAddress = c.emailAddress;
this.address = c.address;
this.birthday = c.birthday;
this.notes = c.notes;
}
public String getName() {
    return name;
    }

    public String getPhoneNumber() {
    return phoneNumber;
    }

    public String getEmailAddress() {
    return emailAddress;
    }

    public String getAddress() {
    return address;
    }

    public String getBirthday() {
    return birthday;
    }

    public String getNotes() {
    return notes;
    }

    public void setName(String name) {
    this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    }

    public void setAddress(String address) {
    this.address = address;
    }

    public void setBirthday(String birthday) {
    this.birthday = birthday;
    }

    public void setNotes(String notes) {
    this.notes = notes;
    }

    @Override
    public String toString() {
    return "Name: " + name + "\n" +
    "Phone Number: " + phoneNumber + "\n" +
    "Email Address: " + emailAddress + "\n" +
    "Address: " + address + "\n" +
    "Birthday: " + birthday + "\n" +
    "Notes: " + notes + "\n";
    }

    public boolean addEvent( Event e){
         
        if(events.empty())
        events.insertSort(e);
        return true;

        else{
///////////////////////////
        }

    }

    public boolean removeEvent( String eventTitle){
         if()
    }
    
@Override
public int compareTo(Contact o) {
return this.name.compareTo(o.name);
}


}
//test
