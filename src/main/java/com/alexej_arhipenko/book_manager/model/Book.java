package com.alexej_arhipenko.book_manager.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Book.DELETE, query = "DELETE FROM Book b WHERE b.id=:id"),
        @NamedQuery(name = Book.GET_ALL, query = "SELECT b FROM Book b")
})

@Entity
@Table(name = "books")
public class Book extends AbstractBaseEntity {

    public static final String GET_ALL = "Book.getAll";
    public static final String DELETE = "Book.delete";

    @Column(name = "title")
    @NotBlank(message = "Enter a title")
    private String title;

    @Column(name = "description")
    @NotBlank(message = "Enter a title")
    @Size(min = 1, max = 255, message = "Description must contain from 1 to 255 characters")
    private String description;

    @Column(name = "author")
    @NotBlank(message = "Enter a author")
    private String author;

    @Column(name = "isbn")
    @NotNull(message = "Enter ISBN")
    @Pattern(regexp = "^978[0-9]{10}$", message = "Enter correct ISBN. 13 digit starts with 978")
    private String isbn;

    @Column(name = "printYear")
    //need make annotation for validation!
    private int printYear;

    @Column(name = "readAlready")
    private boolean readAlready;


    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", printYear=" + printYear +
                ", readAlready=" + readAlready +
                '}';
    }
}
