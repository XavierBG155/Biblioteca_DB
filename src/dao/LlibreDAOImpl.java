package dao;

import model.Llibre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LlibreDAOImpl implements LlibreDAO {


    @Override
    public void insert(Llibre llibre) throws SQLException {
        String DB_USERNAME = "xavi";
        String DB_PASSWORD = "1234";
        String DB_HOST = "localhost:3306";
        String DB_DBNAME = "biblioteca";
        Connection con;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://" + DB_HOST + "/" + DB_DBNAME,
                    DB_USERNAME, DB_PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "INSERT INTO llibre (autor, editorial, pagines, titol) VALUES ('"
                +llibre.getAutor()+"','"+llibre.getEditorial()+"','"
                + llibre.getPagines()+"','"+llibre.getTitol() + "');";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        ps.close();
        con.close();
    }
}
