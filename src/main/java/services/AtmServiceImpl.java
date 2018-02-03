package services;

import daos.AtmDao;
import models.Notes;
import utils.Calculation;

import javax.inject.Inject;

public class AtmServiceImpl implements AtmService {
    private AtmDao atmDao;

    @Inject
    public AtmServiceImpl(AtmDao atmDao) {
        this.atmDao = atmDao;
    }

    @Override
    public Notes withdraw(Long cash) {
        Notes reducedNotes = Calculation.calculateNotesFromCash(cash);

        atmDao.remove(reducedNotes);

        return reducedNotes;
    }
}
