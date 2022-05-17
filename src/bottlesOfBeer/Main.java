package bottlesOfBeer;

public class Main {

    public static void main(String[] args) {

        for(int i = 29; i > 0; i--) {
            if(i>1) {
                System.out.println(i+" bottles of beer on the wall, "+i+" bottles of beer.\n" +
                        "Take one down and pass it around, "+(i-1)+" bottle of beer on the wall.");
            } else {
                System.out.println("1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.");
            }
        }
        System.out.println("No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.");
    }
}
