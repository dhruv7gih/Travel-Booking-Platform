import util.LogMonitor;

public class TestThread {
    public static void main(String[] args) {
        LogMonitor monitor = new LogMonitor();
        monitor.start();   // 🔥 THREAD START

        System.out.println("Main thread running...");
    }
}