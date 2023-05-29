package model;

public class Llibre {
    private String titol;

    private String autor;
    private String editorial;
    private int pagines;

    public Llibre(String titol, String autor, String editorial, int pagines) {
        this.titol = titol;
        this.autor = autor;
        this.editorial = editorial;
        this.pagines = pagines;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPagines() {
        return pagines;
    }

    public void setPagines(int pagines) {
        this.pagines = pagines;
    }
}
