package com.aptron.covid19tracker;

import java.util.ArrayList;

class CountryModel2 {
    private String state;
    private ArrayList<DistrictModel1> district;


    public CountryModel2(String state, ArrayList<DistrictModel1> district) {
        this.state = state;
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public ArrayList<DistrictModel1> getDistrict() {
        return district;
    }
}

