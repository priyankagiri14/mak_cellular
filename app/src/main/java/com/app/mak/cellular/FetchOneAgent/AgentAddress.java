package com.app.mak.cellular.FetchOneAgent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentAddress {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("streetNo")
    @Expose
    private String streetNo;
    @SerializedName("streetName")
    @Expose
    private String streetName;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("suburb")
    @Expose
    private String suburb;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
