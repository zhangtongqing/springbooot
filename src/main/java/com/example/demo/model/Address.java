package com.example.demo.model;

/**
 * Created by Administrator on 2018/4/3.
 */
public class Address {
    private Long id;
    private String province;

    public Address() {
    }

    public Address(Long id, String province, String city) {
        this.id = id;
        this.province = province;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String city;
}
