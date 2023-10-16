package dal;

import java.util.*;

interface IBookFetcher {
  Map<String, Boolean> getAllBooks(String seriesName, String authorName);
 
 }