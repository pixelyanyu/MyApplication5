package com.example.lianxi5.bean;

/*
 *@Auther:田恒宇
 *@weichat: 15020451581
 *@Description:function
 */
public class ListBean {
    private String logo;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "ListBean{" +
                "logo='" + logo + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ListBean(String logo, String name, String address) {
        this.logo = logo;
        this.name = name;
        this.address = address;
    }
}
