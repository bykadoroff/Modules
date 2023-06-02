package ua.bykadoroff.module2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;

public class Main {
    private static InterfaceForTask lastTask;
    private static Instant lastTaskStartTime;

    public static void main(String[] args) {

        InterfaceForTask task1 = new Task1();
        InterfaceForTask task2 = new Task2();
        InterfaceForTask task3 = new Task3();

        runTask(task1);
        runTask(task2);
        runTask(task3);
    }

    static void runTask(InterfaceForTask task) {
        Instant now = Instant.now();

        if (lastTask != null) {
            Duration timeSinceLastTask = Duration.between(lastTaskStartTime, now);
            if (timeSinceLastTask.getSeconds() < lastTask.timeForTask()) {
                System.out.println("Line is busy. Task in progress: " + lastTask.getClass().getSimpleName());
                return;
            }
        }

        lastTask = task;
        lastTaskStartTime = now;
        System.out.println("Starting task: " + task.getClass().getSimpleName());
        task.doWork();
        Duration taskDuration = Duration.between(lastTaskStartTime, Instant.now());
        System.out.println("Task completed in: " + taskDuration.getSeconds() + " seconds");

        writeToFile(task, taskDuration);
    }

    private static void writeToFile(InterfaceForTask task, Duration duration) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./src/main/java/ua/bykadoroff/module2/log.txt", true))) {
            writer.println("Task: " + task.getClass().getSimpleName());
            writer.println("Time taken: " + duration.getSeconds() + " seconds");
            writer.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
