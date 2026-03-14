package fit;

// Bước 1: Tạo interface cho các loại thông báo
interface Notification {
    void sendMessage(String message);
}

// Bước 2: Implement từng loại thông báo cụ thể
class EmailNotification implements Notification {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gửi Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gửi SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gửi Push Notification: " + message);
    }
}

// Bước 3: Tạo Factory để tạo thông báo
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        throw new IllegalArgumentException("Loại thông báo không hợp lệ!");
    }
}

// Bước 4: Kiểm thử Factory Pattern
public class Main {
    public static void main(String[] args) {
        // Tạo các thông báo bằng Factory
        Notification email = NotificationFactory.createNotification("EMAIL");
        email.sendMessage("Chào bạn, đây là thông báo qua Email!");

        Notification sms = NotificationFactory.createNotification("SMS");
        sms.sendMessage("Chào bạn, đây là thông báo qua SMS!");

        Notification push = NotificationFactory.createNotification("PUSH");
        push.sendMessage("Chào bạn, đây là Push Notification!");
    }
}