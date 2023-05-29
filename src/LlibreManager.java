import dao.LlibreDAO;
import dao.LlibreDAOImpl;
import model.Llibre;

import java.sql.SQLException;

public class LlibreManager {
    public static void main(String[] args) throws SQLException {
        Llibre llibre = new Llibre("El Quijote", "Cervantes", "Anaya", 536);
        LlibreDAO llibreDAO = new LlibreDAOImpl();
        llibreDAO.insert(llibre);
    }
}
