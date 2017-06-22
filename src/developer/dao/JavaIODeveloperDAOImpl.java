package developer.dao;

import developer.model.Developer;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Zver on 20.06.2017.
 */
public class JavaIODeveloperDAOImpl implements DeveloperDAO {

    private String sep = File.separator;
    private String user = System.getProperty("user.dir");
    private File file = new File(user + sep + "Textfile");

    @Override
    public void save(Developer developer) {
        String developerToString = "";
        developerToString += developer.getId() + ", ";
        developerToString += developer.getFirstName() + ", ";
        developerToString += developer.getSecondName() + ", ";
        developerToString += developer.getSpeciality() + ", ";
        developerToString += developer.getSalary() + "/\n";
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            fileOutputStream.write((developerToString.getBytes()));
            System.out.println("Developer : " + developer + "successfully created");
        } catch (IOException e) {
            System.out.println("Something goes wrong");
        }
    }

    @Override
    public void update(Developer developer) {
        Developer developerr = new Developer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What you gonna do with your developer?");
        System.out.println("1. Edit first name \n" +
                "2. Edit last name \n" +
                "3. Edit speciality \n" +
                "4. Edit salary \n" +
                "5. That's fine,lets do another things");
        try {
            String line = reader.readLine();
            switch (line) {
                case "1":
                    System.out.println("Enter a new first name of your developer");
                    developerr.setFirstName(reader.readLine());
                    break;
                case "2":
                    System.out.println("Enter a new last name of your developer");
                    developerr.setSecondName(reader.readLine());
                    break;
                case "3":
                    System.out.println("Enter a new speciality of your developer");
                    developerr.setSpeciality(reader.readLine());
                    break;
                case "4":
                    System.out.println("Enter a new salary for your developer");
                    developerr.setSalary(Integer.parseInt(reader.readLine()));
                    break;
                case "5":
                    break;

                default:
                    System.err.println("Please enter 1-5");
                    break;
            }

        } catch (IOException e) {
            System.err.println("Its not a number");
        }

    }

    @Override
    public Developer getById(Long ID) {
        Developer developer = new Developer();
        try {
            FileReader reader
                    = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] arrayOfSplitDeveloper = line.split(",");
                if ((Integer.parseInt(arrayOfSplitDeveloper[0]) == ID)) {
                    developer.setId(Long.parseLong(arrayOfSplitDeveloper[0]));
                    developer.setFirstName(arrayOfSplitDeveloper[1]);
                    developer.setSecondName(arrayOfSplitDeveloper[2]);
                    developer.setSpeciality(arrayOfSplitDeveloper[3]);
                    developer.setSalary(Integer.parseInt(arrayOfSplitDeveloper[4]));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Developer : " + developer + "successfully loaded");
        return developer;
    }

    @Override
    public boolean remove(Developer developer) {

        List<Developer> developers = new ArrayList<>();
        for (Developer developerone : developers) {
            if (developers.contains(developerone)) {
                developers.remove(developerone);
                getAll();
                System.out.println("Successfully removed your developer");
                return true;
            }
        }
        System.out.println("Cant find your developer");
        return false;
    }

    @Override
    public Collection<Developer> getAll() {
        List<Developer> developers = new ArrayList();
        Developer tempDeveloper = new Developer();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader reader1 = new BufferedReader(reader);
            String buffer;
            while ((buffer = reader1.readLine()) != null) {
                if (buffer.isEmpty()) {
                    continue;
                }
                String[] arrayOfSplitDeveloper = buffer.split(",");

                tempDeveloper.setId(Long.parseLong(arrayOfSplitDeveloper[0]));
                tempDeveloper.setFirstName(arrayOfSplitDeveloper[1]);
                tempDeveloper.setSecondName(arrayOfSplitDeveloper[2]);
                tempDeveloper.setSpeciality(arrayOfSplitDeveloper[3]);
                tempDeveloper.setSalary(Integer.parseInt(arrayOfSplitDeveloper[4]));
                developers.add(tempDeveloper);
            }
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return developers;
    }
}
