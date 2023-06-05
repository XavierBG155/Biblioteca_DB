import dao.LlibreDAO;
import dao.LlibreDAOImpl;
import model.Llibre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LlibreManager {
    static Scanner scanner = new Scanner(System.in);
    private static String titol;
    private static String autor;
    private static String editorial;
    public static void main(String[] args) throws SQLException {
        LlibreDAO llibreDAO = new LlibreDAOImpl();

        System.out.println("  *****************************\n" +
                "     **\t\t\t\t\t      **\n" +
                "     **\t\tBIBLIOTECA\t\t  **\n" +
                "     **\t\t\t\t\t      **\n" +
                "  *****************************\n");
        System.out.println("1) Cercar llibres per autor\n" +
                "2) Cercar llibres per títol\n" +
                "3) Cercar llibres per editorial\n");


        System.out.print("--> Opció: ");
        int option = scanner.nextInt();
        scanner = new Scanner(System.in);
        if (option == 1) {
            System.out.print("Introdueix l'autor: ");
            autor = scanner.nextLine();
            mostraLlibres(llibreDAO, autor, titol, editorial);
        } else if (option == 2){
            System.out.print("Introdueix el titol: ");
            titol = scanner.nextLine();
            mostraLlibres(llibreDAO, autor, titol, editorial);
        } else {
            System.out.print("Introdueix l'editorial: ");
            editorial = scanner.nextLine();
            mostraLlibres(llibreDAO, autor, titol, editorial);
        }
    }

    private static void mostraLlibres(LlibreDAO llibreDAO, String autor, String titol, String editorial) throws SQLException {
        List<Llibre> list = new ArrayList<>();

        if (autor != null) {
            list = llibreDAO.readAut(autor);
        }else if (titol != null){
            list = llibreDAO.readTitol(titol);
        } else {
            list = llibreDAO.readEditorial(editorial);
        }
        for (Llibre llibre : list) {
            System.out.printf("""
                    Trobat els següents llibres:
                    +-------------------------------+
                    |\t%-28s|
                    |\tAutor: %-21s|
                    |\tEditorial: %-17s|
                    |\tPàgines: %-19d|
                    +-------------------------------+
                    """, llibre.getTitol(), llibre.getAutor(), llibre.getEditorial(), llibre.getPagines());
        }
    }
}
