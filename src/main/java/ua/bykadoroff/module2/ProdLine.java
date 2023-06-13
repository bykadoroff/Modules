package ua.bykadoroff.module2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;

public class ProdLine {
    private static InterfaceForTask lastTask;
    private static Instant lastTaskStartTime;

    public static void main(String[] args) {

        ProdLine main = new ProdLine();

        InterfaceForTask task1 = new Task1();
        InterfaceForTask task2 = new Task2();
        InterfaceForTask task3 = new Task3();

        main.runTask(task1);
        main.runTask(task2);
        main.runTask(task3);
    }

    void runTask(InterfaceForTask task) {
        Instant now = Instant.now();

        if (lastTask != null) {
            Duration timeSinceLastTask = Duration.between(lastTaskStartTime, now);
            if (timeSinceLastTask.getSeconds() < lastTask.timeForTask()) {
                System.out.println("Line is busy. Task in progress: " + lastTask.getClass().getSimpleName());
                writeToFile("Line is busy. Task in progress: " + lastTask.getClass().getSimpleName());
                return;
            }
        }

        lastTask = task;
        lastTaskStartTime = now;
        System.out.println("Starting task: " + task.getClass().getSimpleName());
        writeToFile("Task started: " + task.getClass().getSimpleName());
        task.doWork();
        Duration taskDuration = Duration.between(lastTaskStartTime, Instant.now());
        System.out.println("Task completed in: " + taskDuration.getSeconds() + " seconds");
        writeToFile("Task completed: " + task.getClass().getSimpleName());
        writeToFile("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    }

    private void writeToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("untitled1/src/main/java/ua/bykadoroff/module2/log.txt", true))) {
            writer.println(message);
            writer.println("Time: " + Instant.now());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
