package pl;

import java.util.List;

import bll.Poem;

public interface GUIInterface {
    void importPoems();
   void displayPoems(List<Poem> poems);
}
