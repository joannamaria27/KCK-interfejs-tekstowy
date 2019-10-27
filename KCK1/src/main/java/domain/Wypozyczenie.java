package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Wypozyczenie {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private long id_pojazdu;
    private String data_wypozyczenia;
    private String data_oddania;
    private String kod_dostepu;
    @OneToOne
    private long id_klienta;
    private Float cena;
    private String pracownik;


    public Wypozyczenie(long id_pojazdu_, String data_wypozyczenia_,String data_oddania_, String kod_dostepu_, long id_klienta_, Float cena_, String pracownik_){
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

    public long getId_pojazdu() {
        return id_pojazdu;
    }

    public void setId_pojazdu(long id_pojazdu) {
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

    public long getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(long id_klienta) {
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
}
