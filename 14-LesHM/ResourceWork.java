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

    public void WorkWithResource() {
        SameResource resSame = null;
        try {
            resSame = new SameResource();
            resSame.execute();
        } finally {
            if (resSame != null) {
                resSame.close();
            }
        }
    }

    public void WorkWithResource_v2() {
        try (SameResourceAutoClose resSame = new SameResourceAutoClose()) {
            resSame.execute();
        }
    }
}
