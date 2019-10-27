package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Klient {

    @Id
    @GeneratedValue
    private long id;
    private String nr_prawa_jazdy;
    private String numer_tel;
    //private Adres adres;

    public Klient(long id_, String nr_prawa_jazdy_, String numer_tel_){
        id = id_;
        nr_prawa_jazdy = nr_prawa_jazdy_;
        numer_tel = numer_tel_;
    }


}
