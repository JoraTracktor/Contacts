package contacts;

import java.io.*;

public class SerializationUtils {

    public static void serialize(Object obj, String fileName) {
        try( FileOutputStream fos = new FileOutputStream(fileName);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos);){

            oos.writeObject(obj);
        } catch (IOException e){

        }
    }

    /**
     * Deserialize to an object from the file
     */
    public static Object deserialize(String fileName) {
        Object obj = null;
        try( FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis);){

            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        return obj;
    }
}
