package ua.bykadoroff.module2;

import java.time.Duration;
import java.time.Instant;

public class Task2 implements InterfaceForTask {
    private int timeInSecForTaskMaking;
    private String processText;

    public Task2() {
        timeInSecForTaskMaking = 12;
        processText = "Sawing a wooden block 15 cm thick";
    }

    @Override
    public int timeForTask() {
        return timeInSecForTaskMaking;
    }

    @Override
    public void doWork() {
        System.out.println("Task in process: " + processText);
        Instant start = Instant.now();

        try {
            Thread.sleep(timeInSecForTaskMaking * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Time for task complete: " + duration.getSeconds() + " seconds");
    }
}
