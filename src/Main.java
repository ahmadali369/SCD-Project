import java.awt.*;
import javax.swing.*;

import dal.BooksDAO;
import pl.Presentation;

public class Main {
  public static void main(String[] args) {
    Presentation p = new Presentation();
    BooksDAO dal = new BooksDAO();
//    Businesslogic bl = new Businesslogic();
p.setVisible(true);
    
  }
}
