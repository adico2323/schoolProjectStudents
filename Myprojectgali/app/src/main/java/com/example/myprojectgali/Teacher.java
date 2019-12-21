package com.example.myprojectgali;

public class Teacher {
    private String name;
    private int image;
    private String subject;


    public Teacher(String name, String pass, String subject) {
        this.name = name;
        this.image= image;
        this.subject=subject;
    }
    public int getPass() {
        return image;
    }

    public void setPass(int image) {
        this.image = image;
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
}
