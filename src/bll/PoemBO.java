package bll;

import dal.PoemDAO;
import transerObjects.Main;
import java.sql.SQLException;

public class PoemBO {
	private PoemDAO poemDAO;

    public PoemBO() {
        this.poemDAO = new PoemDAO();
    }

    public void savePoem(Main poem) throws SQLException {
        poemDAO.savePoem(poem);
    }
    
    public void insertDataFromJTable(Main poem) throws SQLException {
        poemDAO.insertDataFromJTable(poem);
    }

}
