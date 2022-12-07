package krg.petr.otus.javabasic;

import java.io.*;

public class ResourceWork {
    private String nameFile;

  public ResourceWork(String nf) {
      this.nameFile = nf;
  }

  public void setNameFile(String nf) {
      this.nameFile = nf;
  }

  public String readFile()  throws IOException {
          BufferedReader reader = new BufferedReader(new FileReader(nameFile));
          String firstString = reader.readLine();
          return firstString;
  }
}
