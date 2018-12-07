package hu.iit.me.model;

import hu.iit.me.exception.EmptyFieldException;
import hu.iit.me.exception.InvalidIDException;
import hu.iit.me.exception.NegativeValueException;

public class Applicant {
    private int applicantID;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;

    public Applicant(int applicantID, String name, String email, String phoneNumber, int age) throws InvalidIDException, EmptyFieldException, NegativeValueException{
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

    public void setEmail(String email) throws EmptyFieldException{
        if (email.equals("")){
            throw new EmptyFieldException();
        }
        this.email = email;
    }

    public String getPhoneNumbe(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws EmptyFieldException{
        if (phoneNumber.equals("")){
            throw new EmptyFieldException();
        }
        this.phoneNumber = phoneNumber;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) throws NegativeValueException {
        if(age<1){
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
