package dao;

import model.Llibre;

import java.sql.SQLException;

public interface LlibreDAO {
    public void insert(Llibre llibre) throws SQLException;
}
