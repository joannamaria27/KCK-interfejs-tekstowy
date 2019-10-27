package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity public class Pojazd {
    @Id
    @GeneratedValue
    private long id;
    private String marka;
    private String model;
    private String stan_pojazdu;
    private boolean dostepnosc;

    public Pojazd(String marka_, String model_, String stan_pojazdu_, boolean dostepnosc_){
        marka = marka_;
        model = model_;
        stan_pojazdu = stan_pojazdu_;
        dostepnosc = dostepnosc_;
    }

    public Pojazd(String[] choices){
        marka = choices[0];
        model = choices[0];
        stan_pojazdu = choices[0];
        if(choices[3].equals("tak")) dostepnosc = true;
    }


}
