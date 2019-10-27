package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity public class Pojazd {
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

    public Pojazd(String[] choices){
        typ=choices[0];
        marka = choices[1];
        model = choices[2];
        id_ubezpieczenia=choices[3];
        stan_pojazdu = choices[4];
        dostepnosc = choices[5];

    }


}
