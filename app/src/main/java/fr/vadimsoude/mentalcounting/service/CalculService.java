package fr.vadimsoude.mentalcounting.service;

import fr.vadimsoude.mentalcounting.database.CalculDao;
import fr.vadimsoude.mentalcounting.entity.Calcul;

public class CalculService {

    private CalculDao calculDao;

    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public long getCalculNumber(){
        return calculDao.count();
    }

    public void storeCalculInDb(Calcul calcul){
        calculDao.create(calcul);
    }
}
