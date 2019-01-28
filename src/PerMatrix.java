package KhiemNguyen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PerMatrix implements Serializable
/*
 * Persistence class for read and save object.
 */
{ public matrixClass[] matrixData;
  public PerMatrix(matrixClass[] matrixFromModel) {matrixData = matrixFromModel;}
  public matrixClass[] readFile(String file) 
  {
    	 
      try { FileInputStream fi = new FileInputStream(new File(file));
			  ObjectInputStream oi = new ObjectInputStream(fi);
			  // Read object
			  matrixData = (matrixClass[]) oi.readObject();

		      oi.close();
			  fi.close();
			  System.out.println("file opened as an object");
          } 
      catch (ClassNotFoundException e) {System.out.println("Class not found"); }
      catch (FileNotFoundException e) {System.out.println("File not found"); }
	  catch (IOException e) {System.out.println("Error initializing stream"); }
	  return matrixData;
	 
} 
  public void saveFile(String file) {
	try {
			FileOutputStream f = new FileOutputStream(new File(file));
			ObjectOutputStream o = new ObjectOutputStream(f);
			//Save object
            o.writeObject(matrixData);

			o.close();
			f.close();
			System.out.println("file saved as object");

		} 
	catch (FileNotFoundException e) {System.out.println("File not found");}
	catch (IOException e) {System.out.println("Error initializing stream");}	 
  } 
  
}
