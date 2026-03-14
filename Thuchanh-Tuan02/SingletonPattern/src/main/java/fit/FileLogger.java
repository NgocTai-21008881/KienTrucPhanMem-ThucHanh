package fit;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Abstract Logger để dễ mở rộng
abstract class Logger {
    protected PrintWriter writer;

    public abstract void log(String message);
}

// Singleton Logger
public class FileLogger extends Logger {
    private static FileLogger instance;

    private FileLogger() {
        try {
            FileWriter fileWriter = new FileWriter("app.log", true);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        writer.println(timestamp + " - " + message);
    }

    public static FileLogger getInstance() {
        if (instance == null) {
            synchronized (FileLogger.class) {
                if (instance == null) { // Double-checked locking
                    instance = new FileLogger();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // Lấy instance của Logger
        FileLogger logger1 = FileLogger.getInstance();
        FileLogger logger2 = FileLogger.getInstance();

        // Kiểm tra Singleton
        System.out.println(logger1 == logger2); // true

        // Ghi log
        logger1.log("Ứng dụng đã khởi động.");
        logger2.log("Người dùng đăng nhập thành công.");
    }
}