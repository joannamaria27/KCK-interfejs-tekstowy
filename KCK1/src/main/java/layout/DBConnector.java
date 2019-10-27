package layout;

import domain.Klient;
import domain.Pojazd;
import domain.Wypozyczenie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public static DBConnector getInstance() {
        if(instance == null) instance = new DBConnector();
        return instance;
    }

    private static DBConnector instance;

    private DBConnector(){
        entityManagerFactory = Persistence.createEntityManagerFactory("wypozyczalnia");
        entityManager = entityManagerFactory.createEntityManager();

//        Wypozyczenie wypozyczenie = new Wypozyczenie();
//        wypozyczenie.setData_wypozyczenia(new Date());
//        wypozyczenie.setId_klienta(1);
//        wypozyczenie.setId_pojazdu(2);
//        wypozyczenie.setKaucja(1717);
//        wypozyczenie.setStan_pojazdu("dobry");
//        wypozyczenie.setId_pracownika(3);
//        wypozyczenie.setKod_dostepu(4444);


    }

    public void addWypozyczenie(Wypozyczenie w){
        entityManager.getTransaction().begin();
        entityManager.persist(w);
        entityManager.getTransaction().commit();
    }

    public void addWypozyczenie(){
        entityManager.getTransaction().begin();

        // todo
        //entityManager.persist();


        entityManager.getTransaction().commit();
    }



    public void addKlient(Klient k){
        entityManager.getTransaction().begin();
        entityManager.persist(k);
        entityManager.getTransaction().commit();
    }

    public void addPojazd(Pojazd p){
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    public void stop(){
        entityManager.close();
        entityManagerFactory.close();
    }


}
