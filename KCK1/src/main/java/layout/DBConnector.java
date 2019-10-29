package layout;

import domain.Klient;
import domain.Pojazd;
import domain.Wypozyczenie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class DBConnector {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public static DBConnector getInstance() {
        if (instance == null) instance = new DBConnector();
        return instance;
    }

    private static DBConnector instance;

    public void start(){
        //entityManagerFactory = Persistence.createEntityManagerFactory("wypozyczalnia");
        //entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    private DBConnector() {
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

    public void addWypozyczenie(Wypozyczenie w) {
        //entityManager.getTransaction().begin();
        entityManager.persist(w);
        //entityManager.getTransaction().commit();
    }

    public void addWypozyczenie() {
        entityManager.getTransaction().begin();

        // todo
        //entityManager.persist();


        entityManager.getTransaction().commit();

    }
    public List<Wypozyczenie> printAllRentals() {
        List<Wypozyczenie> list = entityManager.createQuery("SELECT a FROM Wypozyczenie a", Wypozyczenie.class).getResultList();
        for (Wypozyczenie wypozyczenie : list) {
            System.out.println(wypozyczenie.getId());
        }
        return list;
    }


    public void addKlient(Klient k) {
        entityManager.getTransaction().begin();
        entityManager.persist(k);
        entityManager.getTransaction().commit();
    }

    public void addPojazd(Pojazd p) {
        //entityManager.getTransaction().begin();
        entityManager.persist(p);
        //entityManager.getTransaction().commit();
    }

    public void deletePojazd(Pojazd p) {
        entityManager.remove(p);
    }
    public void deleteKlient(Klient k) {
        entityManager.remove(k);
    }
    public void deleteWypozyczenie(Wypozyczenie w) {
        entityManager.remove(w);
    }

    // nie wiem czy działa
    public void editPojazd(Pojazd p)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();
    }
    public void editKlient(Klient k)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(k);
        entityManager.getTransaction().commit();
    }
    public void editWypozyczenie(Wypozyczenie w)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(w);
        entityManager.getTransaction().commit();
    }

    public void stop() {
        entityManager.getTransaction().commit();
    }

    public void stopdb(){
        entityManager.close();
        entityManagerFactory.close();
    }

    public static List<Pojazd> getAllCars() throws IOException {
        return DBConnector.getInstance().entityManager.createQuery("SELECT a FROM Pojazd a", Pojazd.class).getResultList();
    }
}