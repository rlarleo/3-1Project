package com.example.login_project;

public class MemberInfo {
    private String name;
    private String age;
    private String weight;
    private String height;
    public MemberInfo(String name, String age, String weight, String height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        this.age = age;
    }

    public String getWeight(){
        return this.weight;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }

    public String getHeight(){
        return this.height;
    }
    public void setHeight(String height){
        this.height = height;
    }


}
