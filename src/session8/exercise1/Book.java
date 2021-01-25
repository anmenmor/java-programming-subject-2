package session8.exercise1;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Book implements SQLData {

    private static final String SQL_TYPE_NAME = "BOOK";
    private String isbn;
    private String title;
    private String author;
    private int edition;

    //IMPORTANT: The class has to be a null Construtor to avoid InstantiationException
    public Book() {
    }

    public Book(String isbn, String title, String author, int edition) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    // retrieves the fully qualified name of the SQL
    // user-defined type that this object represents.
    public String getSQLTypeName() {
        return SQL_TYPE_NAME;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", edition=" + edition +
                '}';
    }

    // populates this object with data it reads from stream
    public void readSQL(SQLInput stream, String sqlType) throws SQLException {
        this.isbn = stream.readString();
        this.title = stream.readString();
        this.author = stream.readString();
        this.edition = stream.readInt();
    }

    // writes this object to stream
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(this.isbn);
        stream.writeString(this.title);
        stream.writeString(this.author);
        stream.writeInt(this.edition);
    }

    public void print() {
        System.out.println("isbn=" + isbn);
        System.out.println("title=" + title);
        System.out.println("author=" + author);
        System.out.println("edition=" + edition);
    }
}