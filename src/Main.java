import dal.BooksDAO;
import pl.BooksPO;
import bll.BooksBLO;

public class Main {
  public static void main(String[] args) {
    
    BooksDAO dal = new BooksDAO();
    BooksBLO bl = new BooksBLO(dal);
    BooksPO p = new BooksPO(bl);
p.setVisible(true);
    
  }
}
