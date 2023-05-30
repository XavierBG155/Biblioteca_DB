import dao.LlibreDAO;
import dao.LlibreDAOImpl;
import model.Llibre;

import java.sql.SQLException;
import java.util.Scanner;

public class LlibreManager {
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


        Scanner scanner = new Scanner(System.in);
        System.out.print("--> Opció: ");
        int option = scanner.nextInt();

        if (option == 1){
            scanner = new Scanner(System.in);
            System.out.print("Introdueix l'autor: ");
            String autor = scanner.nextLine();
            Llibre llibre = llibreDAO.readAut(autor);
            System.out.printf("Trobat els següents llibres:\n" +
                    "+-------------------------------+\n" +
                    "|\t%s      |\n" +
                    "|\tAutor: %s    |\n" +
                    "|\tEditorial: %s       |\n" +
                    "|\tPàgines: %d               |\n" +
                    "+-------------------------------+\n", llibre.getTitol(), llibre.getAutor(), llibre.getEditorial(), llibre.getPagines());
        }


    }
}
