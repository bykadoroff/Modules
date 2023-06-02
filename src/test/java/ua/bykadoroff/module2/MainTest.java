package ua.bykadoroff.module2;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void testRunTask_SuccessfulTask() {
        Main main = new Main();
        InterfaceForTask task1 = new Task1();

        try {
            main.runTask(task1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRunTask_BusyLine() {
        Main main = new Main();
        InterfaceForTask task1 = new Task1();
        InterfaceForTask task2 = new Task2();
        InterfaceForTask task3 = new Task3();

        try {
            main.runTask(task1);
            main.runTask(task2);
            main.runTask(task3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}