package net.codeJava;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "writer")
public class Writer {
	@Id
  private long id;
  private String fullName;
  private String password;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


@Override
public String toString() {
	return "Writer [id=" + id + ", fullName=" + fullName + "]";
}

  
}
