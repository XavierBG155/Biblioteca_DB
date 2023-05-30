package dao;

import model.Llibre;

import java.sql.*;

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
                + llibre.getAutor() + "','" + llibre.getEditorial() + "','"
                + llibre.getPagines() + "','" + llibre.getTitol() + "');";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        ps.close();
        con.close();
    }
    @Override
    public Llibre readAut(String autor) {
        Llibre llibre = null;
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String username = "xavi";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM llibre WHERE autor LIKE ?"
            )) {
                statement.setString(1, "%" + autor + "%");
                ResultSet rs = statement.executeQuery();
                if(rs.next()) {
                    llibre = new Llibre(rs.getString("titol"), rs.getString("autor"),
                            rs.getString("editorial"), rs.getInt("pagines"));
                }
            }
            connection.close();
        } catch (Exception e){
            System.out.println("Error");
        }
        return llibre;
    }

/*    @Override
    public Llibre read(int id) {
        Llibre llibre = null;

        String url = "jdbc:mysql://localhost:8889/biblioteca";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM llibre WHERE id="+id;
            ResultSet rs = statement.executeQuery(select);
            if(rs.next()) {
                llibre = new Llibre(rs.getString("titol"), rs.getString("autor"),
                        rs.getString("editorial"), rs.getInt("pagines"));
            }
            connection.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return llibre;
    }*/
}
