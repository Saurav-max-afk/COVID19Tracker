package com.aptron.covid19tracker;

import java.io.Serializable;

public class DistrictModel1 implements Serializable {

    private String district, active, confirmed, deceased, recovered;

    DistrictModel1(String district,String active,String confirmed,String deceased,String recovered){
        this.district=district;
        this.active=active;
        this.confirmed=confirmed;
        this.deceased=deceased;
        this.recovered=recovered;
    }

    public String getActive() {
        return active;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getDistrict() {
        return district;
    }

    public String getDeceased() {
        return deceased;
    }

}
