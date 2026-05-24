// 1. The Interface matching the file name
interface Sender {
    void sendMessage(String message);
}

// 2. The Email Class
class EmailBot implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("📧 Email sent: " + message);
    }
}

// 3. The Phone Class
class PhoneBot implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("💬 Text message sent: " + message);
    }
}

// 4. The Runner Class (No 'public' keyword here so it fits in Sender.java)
class MessagingSystem {
    public static void main(String[] args) {
        Sender[] communicationTools = {
                new EmailBot(),
                new PhoneBot()
        };

        System.out.println("--- BROADCASTING MESSAGES ---");
        for (Sender tool : communicationTools) {
            tool.sendMessage("Hello World!");
        }
        System.out.println("-----------------------------");
    }
}