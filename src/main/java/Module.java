import com.google.inject.AbstractModule;
import daos.AtmDao;
import daos.AtmDaoImpl;
import services.AtmService;
import services.AtmServiceImpl;
import utils.DatabaseConnection;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(DatabaseConnection.class).toInstance(new DatabaseConnection());
        bind(AtmDao.class).to(AtmDaoImpl.class);
        bind(AtmService.class).to(AtmServiceImpl.class);
    }
}
