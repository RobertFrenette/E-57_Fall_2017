package edu.hes.e57.demo.domain;

import java.io.Serializable;
import java.util.List;

public class Autos implements Serializable {
    private List<Auto> autos;

    public Autos() {}

    public Autos(List<Auto> autos) {
        this.autos = autos;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}
