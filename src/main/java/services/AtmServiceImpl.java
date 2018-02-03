package services;

import daos.AtmDao;
import models.Notes;
import utils.Calculation;
import utils.CustomException;
import utils.DatabaseConnection;

import javax.inject.Inject;

public class AtmServiceImpl implements AtmService {
    private AtmDao atmDao;
    private DatabaseConnection databaseConnection;

    @Inject
    public AtmServiceImpl(AtmDao atmDao, DatabaseConnection databaseConnection) {
        this.atmDao = atmDao;
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Notes withdraw(Long cash) throws CustomException {
        Notes reducedNotes = Calculation.calculateNotesFromCashBasedOnAtm(cash, databaseConnection.getAtm());

        atmDao.remove(reducedNotes);

        return reducedNotes;
    }
}
