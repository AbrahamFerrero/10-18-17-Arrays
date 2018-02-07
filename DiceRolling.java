import java.util.Random;
/**
 * This two methods are a "roll two dices" game. They are intended for the student to learn how to work with Arraylists
 * and therefore I have included a lot of comments as notes and guidelines to understand the process, functions and structure
 * of arraylists. 
 * The first method will give you how many times you get a result from 2 to 12 when you roll the dice a certain amount of times.
 * The second method, does not work with arraylists, and gives you the amount of times you get a 2 or a 12 when rolling 2 dices a
 * certain amount of times.
 * 
 * @author (Abraham Ferrero) 
 * @version (18/OCT/2017)
 */
public class DiceRolling {
    public void Simulate(int rolls){
        Random rand = new Random();
        /*We create an arrayList with 13 places so if it is a 4, we store it in number 4, and so on until 12
         * ignoring 0 and 1, unlikely results.
         */
        int [] counts = new int [13];
        for(int i=0; i < rolls; i++) {
            //rand.nextInt will generate a random number between 0 to 5, that's why we add "+1":
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            /*this replaces the "if" statement we wrote in the method "simpleSimulate" below.
             * We could create one if statement to ask if it is a [i] counts the result of our
             * rolling of 2 dices, add 1 to counts array (2 to 12).
             *
             *The operation between brackets will be stored in the counts arrayList, adding 1 in the
             * socket(array) we get the d1+d2 value (if it is 2+2, it adds 1 in the 4 socket):
             */
            counts[d1+d2] += 1;
        }
        /*We do the loop till 12 cause 12 is the max amount of results. Note that if we write i<=13 or more
         * we'd get an error as our arraylist counts size is 13 (from + to 12), which makes sense.
         */ 
        for (int i=0; i <= 12; i++) {
            System.out.println(i + "'s=\t" + counts[i] + "\tPercentage:\t" + 100.0* counts[i]/rolls);
        }
    }
    
    
    
    /*We will try to do a method without working with arraylists.
     * Basically, we'll roll a dice a defined number of times (rolls) and see how many twos and twelves we get:
     */
    public void simpleSimulate(int rolls){
        Random rand = new Random();
        int twos = 0;
        int twelves = 0;
        for(int i=0; i < rolls; i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            if (d1 + d2 == 2) {
                twos += 1;
            }
            else if (d1 + d2 == 12){
                twelves += 1;
            }
        }
        //Print the result and the percent:
        System.out.println("2's \t "  + twos + "\t" + (100.0*twos)/rolls);
        System.out.println("12's \t "  + twelves + "\t" + 100.0*twelves/rolls);
    }
}
