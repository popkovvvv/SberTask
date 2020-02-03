package com.sberbank.sber.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Serv {

    private String serv_id;
    private String bic;
    private String corr_schet;
    private String schet;
    private List<Pars> pars;

    public String getServ_id() {
        return serv_id;
    }

    public void setServ_id(String serv_id) {
        this.serv_id = serv_id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getCorr_schet() {
        return corr_schet;
    }

    public void setCorr_schet(String corr_schet) {
        this.corr_schet = corr_schet;
    }

    public String getSchet() {
        return schet;
    }

    public void setSchet(String schet) {
        this.schet = schet;
    }

    public List<Pars> getPars() {
        return pars;
    }

    public void setPars(List<Pars> pars) {
        this.pars = pars;
    }
}
