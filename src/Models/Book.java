package Models;

public class Book {
    private String title;
    private String author;
    private int year;
    private String genre;
    private String rentedBy;

    public Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        rentedBy = "None";
    }
    public Book(String title, String author, int year, String genre, String rentedBy) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.rentedBy = rentedBy;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(String rentedBy) {
        this.rentedBy = rentedBy;
    }
}
