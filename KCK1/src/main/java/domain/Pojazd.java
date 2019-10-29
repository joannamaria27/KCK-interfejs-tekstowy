package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity public class Pojazd {

    public Pojazd(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId_ubezpieczenia() {
        return id_ubezpieczenia;
    }

    public void setId_ubezpieczenia(String id_ubezpieczenia) {
        this.id_ubezpieczenia = id_ubezpieczenia;
    }

    public String getStan_pojazdu() {
        return stan_pojazdu;
    }

    public void setStan_pojazdu(String stan_pojazdu) {
        this.stan_pojazdu = stan_pojazdu;
    }

    public String getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(String dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public void setParameters(String[] choices){
        marka = choices[0];
        model = choices[1];
        id_ubezpieczenia=choices[2];
        stan_pojazdu = choices[3];
        dostepnosc = choices[4];
    }

    @Id
    @GeneratedValue
    private long id;
    private String typ;
    private String marka;
    private String model;
    private String id_ubezpieczenia;
    private String stan_pojazdu;
    private String dostepnosc;



    public Pojazd(String typ_, String marka_, String model_, String id_ubezpieczenia_, String stan_pojazdu_, String dostepnosc_){

        typ=typ_;
        marka = marka_;
        model = model_;
        id_ubezpieczenia=id_ubezpieczenia_;
        stan_pojazdu = stan_pojazdu_;
        dostepnosc = dostepnosc_;
    }

    public Pojazd(int id_){
        id = id_;
    }

    public Pojazd(String[] choices, String type){
        typ=type;
        marka = choices[0];
        model = choices[1];
        id_ubezpieczenia=choices[2];
        stan_pojazdu = choices[3];
        dostepnosc = choices[4];
    }


}