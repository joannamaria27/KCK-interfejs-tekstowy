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
    private String nazwisko;
    private String imie;
    private String data_urodzenia;
    private String adres;
    private String pesel;
    private String telefon;
    //private Adres adres;

    public Klient(String nr_prawa_jazdy_, String nazwisko_, String imie_, String data_urodzenia_, String adres_, String pesel_, String telefon_){

        nr_prawa_jazdy=nr_prawa_jazdy_;
        nazwisko=nazwisko_;
        imie=imie_;
        data_urodzenia=data_urodzenia_;
        adres=adres_;
        pesel=pesel_;
        telefon=telefon_;

    }


}
