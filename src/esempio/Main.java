package esempio;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        for(int i = 'a'; i<='g'; i++) {
            sleep(500);
            System.out.println((char)(i));
        }

        String badge = "";
        char letter = 'a';
        int numbers = 999;
        if(numbers == 999) {
            letter += 1;
            numbers = 111;
        }
        numbers++;
        badge += letter;
        badge += numbers;
        System.out.println(badge);

    }
}
