package com.example.gali_project30;

public class Teacher {
    private String name;
    private String subject;


    public Teacher(String name, String subject) {
        this.name = name;
        this.subject=subject;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString(){ return this.name + ": " + this.subject;}
}
