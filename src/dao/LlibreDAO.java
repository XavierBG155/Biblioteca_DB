package dao;

import model.Llibre;

import java.sql.SQLException;
import java.util.List;

public interface LlibreDAO {
    void insert(Llibre llibre) throws SQLException;
    List<Llibre> readAut(String s) throws SQLException;
    List<Llibre> readTitol(String s) throws SQLException;
    List<Llibre> readEditorial(String s) throws SQLException;
}
