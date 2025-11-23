package util;

public class LogMonitor extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Log monitor running in background...");
                Thread.sleep(5000);  // 5 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Log monitor stopped.");
        }
    }
}
