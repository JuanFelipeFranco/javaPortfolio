package org.example.felipe.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtilEntity {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
//EntityManagerFactory nos abre las puertas a la base de datos, despues EntityManager crea la entidad y nos permite hacer las operaciones o consultas
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
