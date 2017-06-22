package developer.view;

import developer.controller.DeveloperController;
import developer.model.Developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Zver on 21.06.2017.
 */
public class DeveloperView {
    private Developer developer = new Developer();
    private DeveloperController developerController = new DeveloperController();

    public void showMenu() {
        System.out.println("=====LETS DO IT=====\n" +
                "1.Create a developer\n" +
                "2.Edit any developer\n" +
                "3.View a developer\n" +
                "4.Delete a developer\n" +
                "5.View all developers\n" +
                "6.Exit an app\n");
        logicMenu();
    }

    public void logicMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int number  = Integer.parseInt(reader.readLine());
            long id = 0L;
            switch (number) {
                case 1:
                    developerController.save(developer);
                    System.out.println("Your developer was successfully saved");
                    showMenu();
                    break;
                case 2:
                    developerController.update(developer);
                    showMenu();
                    break;
                case 3:
                    developerController.getById(id);
                    showMenu();
                    break;
                case 4:
                    developerController.remove(developer);
                    showMenu();
                    break;
                case 5:
                    System.out.println(developerController.getAll());
                    showMenu();
                    break;
                case 6:
                    System.out.println("Exiting the program");
                    System.exit(0);
                default:
                    System.err.println("Please enter 1-6");
                    showMenu();
                    break;
            }
        } catch (IOException e) {
            System.out.println("Please enter a number");
            showMenu();
        }
    }
}
