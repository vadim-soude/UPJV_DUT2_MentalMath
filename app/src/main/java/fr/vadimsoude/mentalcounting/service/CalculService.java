package fr.vadimsoude.mentalcounting.service;

import fr.vadimsoude.mentalcounting.database.CalculDao;

public class CalculService {

    private CalculDao calculDao;

    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public long getCalculNumber(){
        return calculDao.count();
    }
}
