package com.example.myapplication;

public class department {
    String department_name;
    int image_id;
    String department_email;

    String department_url;

    String department_number;

    public department(int id, String name, String url, String email, String callnumber){
        this.image_id = id;
        this.department_name = name;
        this.department_url=url;
        this.department_email = email;
        this.department_number=callnumber;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getDepartment_url()
    {
        return department_url;
    }

    public int getImage_id(){
        return  image_id;
    }

    public String getDepartment_email(){
        return department_email;
    }

    public String getDepartment_number()
    {
        return department_number;
    }


}
