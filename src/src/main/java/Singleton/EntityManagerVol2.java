package Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerVol2 {
    private static EntityManagerFactory entityManager = null;


    private EntityManagerVol2() {
    }

    public static EntityManagerFactory getManager(String persistenceUnitName) {
        if (entityManager == null) {
            entityManager =
                    Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return entityManager;
    }

}
