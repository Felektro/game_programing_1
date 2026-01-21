public class Main {
    public static void main(String[] args) {
        // Start server in background thread
        new Thread(() -> {
            try {
                server.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        // Small delay to let server start
        try { Thread.sleep(500); } catch (InterruptedException e) {}


        System.out.println("Server started successfully");
        /*
        try {
            client.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
    }
}