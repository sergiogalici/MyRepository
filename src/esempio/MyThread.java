package esempio;

public class MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((i+1));
        }
    }
}
