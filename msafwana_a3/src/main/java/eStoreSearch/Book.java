package eStoreSearch;

import java.util.*;
import java.util.ArrayList;

/**
 * Book class where getters and setters are defined for following parameters
 * @param publisher   indicates the publisher of the book
 * @param authors     indicates the author of the book
 */

public class Book extends Product {

  private String publisher;
  private String authors;

  public Book() {

  }

  public Book(String publisher, String authors) throws NullPointerException, Exception {
    this.authors = authors;
    this.publisher = publisher;
  }

  public Book(String price, String year, String description, String publisher, String authors, String productID)
    throws NullPointerException, Exception {

    super(price, year, description, productID);
    this.publisher = publisher;
    this.authors = authors;
  }

  public String getAuthor() {
    return authors;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setAuthor(String newAuthor) {
    this.authors = newAuthor;
  }

  public void setPublisher(String newPublisher) {
    this.publisher = newPublisher;
  }

  @Override
  public String toString() {
    return "type = \"book\"" + "\n" + super.toString() + "authors = " + "\"" + authors + "\"" + "\n" + "publisher = " + "\"" + publisher + "\"";
  }

  /* @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (authors == null) {
            if (other.authors != null)
                return false;
        } else if (!authors.equals(other.authors))
            return false;
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        return true;
    }*/

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return (
      Objects.equals(publisher, book.publisher) &&
      Objects.equals(authors, book.authors)
    );
  }
}
