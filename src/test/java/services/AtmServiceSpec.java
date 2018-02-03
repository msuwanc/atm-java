package services;

import daos.AtmDao;
import daos.AtmDaoImpl;
import models.Atm;
import models.Notes;
import org.junit.Test;
import utils.Calculation;
import utils.DatabaseConnection;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtmServiceSpec {
    @Test
    public void withdrawSuccess() {
        // Mock
        DatabaseConnection fakeDatabaseConncetion = new DatabaseConnection();
        AtmDao fakeAtmDao = new AtmDaoImpl(fakeDatabaseConncetion);
        AtmService atmService = new AtmServiceImpl(fakeAtmDao);

        // Arguments
        Long cash = 9999L;

        // Test
        Notes expectedResult = new Notes(2L, 1L, 4L, 1L, 9L);
        Notes result = atmService.withdraw(cash);

        assertEquals(expectedResult.getTwenty(), result.getTwenty());
        assertEquals(expectedResult.getFifty(), result.getFifty());
        assertEquals(expectedResult.getHundred(), result.getHundred());
        assertEquals(expectedResult.getFiveHundred(), result.getFiveHundred());
        assertEquals(expectedResult.getThousand(), result.getThousand());
    }
}