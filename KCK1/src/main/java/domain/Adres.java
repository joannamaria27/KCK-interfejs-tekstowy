package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adres {

    @Id
    @GeneratedValue
    private long id;
    private String miasto;
    private String ulica;
    private int nr_domu;
    private String kod_pocztowy;
}
