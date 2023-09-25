package Medchek;

import Medchek.Model.Hospital;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private List<Hospital> hospitals;

    public Dao() {
        this.hospitals = new ArrayList<>();
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
