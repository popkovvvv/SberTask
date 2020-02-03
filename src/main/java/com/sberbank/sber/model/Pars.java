package com.sberbank.sber.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pars {
    List<Par> par;

    public List<Par> getPar() {
        return par;
    }

    public void setPar(List<Par> par) {
        this.par = par;
    }
}
