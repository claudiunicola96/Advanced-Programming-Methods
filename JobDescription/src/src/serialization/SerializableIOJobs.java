package serialization;

import domain.Job;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudiu on 03.11.2016.
 */
public class SerializableIOJobs {
    public static void serialize(String fileName, List<Job> jobList) {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(jobList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Job> deserialize(String fileName) {
        List<Job> list = null;
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream(fileName));
            list = new ArrayList<>();
            try {
                list = (List<Job>) os.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
