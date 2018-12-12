package hu.iit.me.model;

import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.exception.InvalidInputFormatException;
import hu.iit.me.exception.NegativeValueException;

public class Applicant {
    private int applicantID;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;

    public Applicant(int applicantID, String name, String email, String phoneNumber, int age) throws InvalidIDException, EmptyFieldException,InvalidInputFormatException, NegativeValueException{
        this.setApplicantID(applicantID);
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setAge(age);
    }

    public int getApplicantID(){
        return applicantID;
    }

    public void setApplicantID(int applicantID) throws InvalidIDException{
        if(applicantID<1){
            throw new InvalidIDException();
        }
        this.applicantID = applicantID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) throws EmptyFieldException{
        if (name.equals("")){
            throw new EmptyFieldException();
        }
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) throws InvalidInputFormatException{
        if (email.equalsIgnoreCase("[^@]+@[^\\.]+\\..+")) {
            throw new InvalidInputFormatException();
        }
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidInputFormatException {
        if (phoneNumber.equalsIgnoreCase("'/^[0-9\\+][0-9\\-]+$/'\n")) {
            throw new InvalidInputFormatException();
        }
        this.phoneNumber = phoneNumber;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) throws NegativeValueException {
        if(age<0){
            throw new NegativeValueException();
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantID=" + applicantID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
