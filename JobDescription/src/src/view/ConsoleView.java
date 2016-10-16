package view;

import controller.Controller;
import domain.Job;
import domain.Sheet;
import domain.Task;
import exception.IdValidatorException;
import exception.JobException;
import exception.SheetException;
import exception.TaskException;
import validator.IdValidator;
import validator.JobValidator;
import validator.TaskValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by claudiu on 11.10.2016.
 */
public class ConsoleView {
    private Controller controller;
    private Scanner scanner;

    public ConsoleView(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void run() throws JobException, TaskException, IdValidatorException, SheetException {
        this.populate();

        while (true) {
            this.printMenu();
            int option = this.getOption();
            try {
                switch (option) {
                    case 1:
                        this.printJobs();
                        break;
                    case 2:
                        this.addJob();
                        break;
                    case 3:
                        this.updateJob();
                        break;
                    case 4:
                        this.deleteJob();
                        break;
                    case 5:
                        this.printTasks();
                        break;
                    case 6:
                        this.addTask();
                        break;
                    case 7:
                        this.updateTask();
                        break;
                    case 8:
                        this.deleteTask();
                        break;
                    case 9:
                        this.addSheet();
                        break;
                    case 10:
                        this.printSheets();
                        break;
                    default:
                        System.out.println("Goodbye!");
                        return;
                }
//            } catch (JobException jobEx) {
//                System.out.println(jobEx.getMessage());
//            } catch (TaskException taskEx) {
//                System.out.println(taskEx.getMessage());
//            } catch (IdValidatorException idEx) {
//                System.out.println(idEx.getMessage());
//            } catch (SheetException sheetEx) {
//                System.out.println(sheetEx.getMessage());
//            }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("1. List Jobs");
        System.out.println("2. Add Job");
        System.out.println("3. Update Job");
        System.out.println("4. Delete Job");
        System.out.println("5. List Tasks");
        System.out.println("6. Add Task");
        System.out.println("7. Update Task");
        System.out.println("8. Delete Task");
        System.out.println("9. Add Sheet");
        System.out.println("10. List Sheets");
        System.out.println("0. Exit");
    }

    private int getOption() {
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void printJobs() {
        for (Job job : this.controller.getJobs()) {
            System.out.println(job);
        }
    }

    private void printTasks() {
        for (Task task : this.controller.getTasks()) {
            System.out.println(task);
        }
    }

    private void printSheets() {
        for (Sheet sheet : this.controller.getSheets()) {
            System.out.println(sheet);
        }
    }

    private void addJob() throws JobException {
        System.out.println("Name: ");
        String name = this.scanner.nextLine();
        System.out.println("Type(full time, part time): ");
        String type = this.scanner.nextLine();
        this.controller.addJob(name, type);
    }

    private void updateJob() throws JobException {
        System.out.println("Id of job that you want modify");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("Name: ");
        String name = this.scanner.nextLine();
        System.out.println("Type(full time, part time): ");
        String type = this.scanner.nextLine();
        this.controller.updateJob(id, name, type);
    }

    private void deleteJob() throws IdValidatorException {
        System.out.println("Id of job that you want delete");
        int id = this.scanner.nextInt();
        this.controller.deleteJob(id);
    }

    private void addTask() throws TaskException {
        System.out.println("Description: ");
        String description = this.scanner.nextLine();
        this.controller.addTask(description);
    }

    private void updateTask() throws TaskException {
        System.out.println("Id of task that you want modify");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.println("Description: ");
        String description = this.scanner.nextLine();
        this.controller.updateTask(id, description);
    }

    private void deleteTask() throws IdValidatorException {
        System.out.println("Id of task that you want delete");
        int id = this.scanner.nextInt();
        this.controller.deleteTask(id);
    }

    private void addSheet() throws SheetException {
        System.out.println("Id job: ");
        int jobId = this.scanner.nextInt();
        System.out.println("Id task: ");
        int taskId = this.scanner.nextInt();
        this.controller.addSheet(jobId, taskId);
    }

    private void populate() throws JobException, TaskException, SheetException {
        this.controller.addJob("frizer", "full time");
        this.controller.addJob("doctor", "part time");
        this.controller.addJob("inginer", "full time");
        this.controller.addTask("tunde");
        this.controller.addTask("proiecteaza");
        this.controller.addTask("consulta");
        this.controller.addSheet(1, 1);
        this.controller.addSheet(2, 3);
        this.controller.addSheet(3, 2);
    }
}
