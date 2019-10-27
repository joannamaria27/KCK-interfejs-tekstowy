package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Wypozyczenie {

    @Id
    @GeneratedValue
    private long id;
    private long id_pojazdu;
    private Date data_wypozyczenia;
    private int kod_dostepu;
    private String stan_pojazdu;
    //@OneToOne

    private long id_klienta;
    private int kaucja;
    private long id_pracownika;

    public Wypozyczenie(long id_pojazdu_, Date data_wypozyczenia_, int kod_dostepu_, String stan_pojazdu_, long id_klienta_, int kaucja_, long id_pracownika_){
        id_pojazdu = id_pojazdu_;
        data_wypozyczenia = data_wypozyczenia_;
        kod_dostepu = kod_dostepu_;
        stan_pojazdu = stan_pojazdu_;
        id_klienta = id_klienta_;
        kaucja = kaucja_;
        id_pracownika = id_pracownika_;
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

    public Date getData_wypozyczenia() {
        return data_wypozyczenia;
    }

    public void setData_wypozyczenia(Date data_wypozyczenia) {
        this.data_wypozyczenia = data_wypozyczenia;
    }

    public int getKod_dostepu() {
        return kod_dostepu;
    }

    public void setKod_dostepu(int kod_dostepu) {
        this.kod_dostepu = kod_dostepu;
    }

    public String getStan_pojazdu() {
        return stan_pojazdu;
    }

    public void setStan_pojazdu(String stan_pojazdu) {
        this.stan_pojazdu = stan_pojazdu;
    }

    public long getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(long id_klienta) {
        this.id_klienta = id_klienta;
    }

    public int getKaucja() {
        return kaucja;
    }

    public void setKaucja(int kaucja) {
        this.kaucja = kaucja;
    }

    public long getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(long id_pracownika) {
        this.id_pracownika = id_pracownika;
    }
}
