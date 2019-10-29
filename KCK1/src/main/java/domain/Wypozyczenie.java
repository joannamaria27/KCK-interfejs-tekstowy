package domain;

import layout.DBConnector;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Wypozyczenie {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Pojazd id_pojazdu;
    private String data_wypozyczenia;
    private String data_oddania;
    private String kod_dostepu;
    @OneToOne
    private Klient id_klienta;
    private Float cena;
    private String pracownik;


    public Wypozyczenie(Pojazd id_pojazdu_, String data_wypozyczenia_,String data_oddania_, String kod_dostepu_, Klient id_klienta_, Float cena_, String pracownik_){
        id_pojazdu = id_pojazdu_;
        data_wypozyczenia = data_wypozyczenia_;
        data_oddania=data_oddania_;
        kod_dostepu = kod_dostepu_;
        id_klienta = id_klienta_;
        cena=cena_;
        pracownik=pracownik_;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pojazd getId_pojazdu() {
        return id_pojazdu;
    }

    public void setId_pojazdu(Pojazd id_pojazdu) {
        this.id_pojazdu = id_pojazdu;
    }

    public String getData_wypozyczenia() {
        return data_wypozyczenia;
    }

    public void setData_wypozyczenia(String data_wypozyczenia) {
        this.data_wypozyczenia = data_wypozyczenia;
    }

    public String getData_oddania() {
        return data_oddania;
    }

    public void setData_oddania(String data_oddania) {
        this.data_oddania = data_oddania;
    }

    public String getKod_dostepu() {
        return kod_dostepu;
    }

    public void setKod_dostepu(String kod_dostepu) {
        this.kod_dostepu = kod_dostepu;
    }

    public Klient getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(Klient id_klienta) {
        this.id_klienta = id_klienta;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getPracownik() {
        return pracownik;
    }

    public void setPracownik(String pracownik) {
        this.pracownik = pracownik;
    }


    public Wypozyczenie(String[] choices){ //, Pojazd p, Klient k){

//todo
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wypozyczalnia");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        Pojazd p = entityManager.find(Pojazd.class, Long.parseLong(choices[0]));
//        entityManager.getTransaction().commit();
//        id_pojazdu = p;
        data_wypozyczenia = choices[1];
        data_oddania=choices[2];
        kod_dostepu = choices[3];

//todo
        //id_klienta = choices[4];
        cena=Float.parseFloat(choices[5]);
        pracownik=choices[6];


    }
    public Wypozyczenie(){}
}