package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Klient {

    public Klient(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNr_prawa_jazdy() {
        return nr_prawa_jazdy;
    }

    public void setNr_prawa_jazdy(String nr_prawa_jazdy) {
        this.nr_prawa_jazdy = nr_prawa_jazdy;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setParameters(String[] choices){
        nr_prawa_jazdy = choices[0];
        nazwisko = choices[1];
        imie = choices[2];
        data_urodzenia = choices[3];
        adres = choices[4];
        pesel = choices[5];
        telefon = choices[6];
    }

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

    public Klient(String nr_prawa_jazdy_, String nazwisko_, String imie_, String data_urodzenia_, String adres_, String pesel_, String telefon_) {
        nr_prawa_jazdy = nr_prawa_jazdy_;
        nazwisko = nazwisko_;
        imie = imie_;
        data_urodzenia = data_urodzenia_;
        adres = adres_;
        pesel = pesel_;
        telefon = telefon_;
    }

    public Klient(int id_){ id=id_;}

    public Klient(String[] choices) {
        nr_prawa_jazdy = choices[0];
        nazwisko = choices[1];
        imie = choices[2];
        data_urodzenia = choices[3];
        adres = choices[4];
        pesel = choices[5];
        telefon = choices[6];
    }

}
