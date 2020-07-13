package net.codeJava;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class Book {
	@Id
  private long id;
  private String bookName;
  private int pageCount;
  private int writerid;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}
public int getWriterid() {
	return writerid;
}
public void setWriterid(int writerid) {
	this.writerid = writerid;
}
@Override
public String toString() {
	return "Book [id=" + id + ", bookName=" + bookName + ", pageCount=" + pageCount + ", writerid=" + writerid + "]";
}
  
}
