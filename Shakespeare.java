import edu.duke.*;
/** We are going to start with some exercise to practice and learn how to work with Arrays. First of all we need to download this files:
 * Resources: Shakespeare books in a txt format: http://www.dukelearntoprogram.com/course3/archives/CommonWordsData.zip
 * Now we will write the methods to find how many times the most common words in English are repeated through this text files.
 * Please note that mostly every line has a comment added as I am still learning how Arraylist work and this will be helpful for
 * me in a near future. 
 * @author (Abraham Ferrero) 
 * @version (18/10/2017)
 */
public class Shakespeare 
{
    //getCommon returns a whole arraylist of the common words to find in txt files.
    public String[] getCommon(){
        FileResource resource = new FileResource("common.txt");
        //We know this txt file will have 20 values, 20 most common words.
        String[] common = new String[20];
        int index = 0;
        //For every word found in our document store it one by one on each array.
        for(String s: resource.words()){
            common[index] = s;
            index += 1;
        }
        //Return your arraylist to keep working with it.
        return common;
    }
    
    /*This method will try to find a word in a list (common) and if it is there, 
     * it returns the location in the array.
     * This list, we'll see, will be common, which is the most common words.
     */
    public int indexOf(String[] list, String word){
        for (int i=0; i < list.length; i++){
            if (list[i].equals(word)) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
    
    public void countWords(FileResource resource, String[] common, int[] counts){
        for (String word : resource.words()){
            /*for every word (in our fileresource with the plays), convert it to 
             * lower case, and apply the indexOf method to check for common words.
             */
            word = word.toLowerCase();
            int index = indexOf(common, word);
            //Everytime we find the location of the common word in our play, we count 1 for the common word found. 
            if (index != -1){
                counts[index] +=1;
            }
        }
    }
    
    //Now we will use every method above and specify the files we apply them to.
    void countShakespeare(){
        /*We take the plays from the files given as a resource for this exercise. 
         * For testing purposes, we could just add "small.txt"
         * instead of all these files and check it manually. 
         * It would be a smaller and therefore an easier example to test.
         */ 
        String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", 
                        "likeit.txt", "macbeth.txt", "romeo.txt"};
        //Get your Arraylist of the 20 most common English words by calling the method:
        String[] common = getCommon();
        // Counts will be the arraylist int, with the ammount of times the words are repeated (the counts)
        int[] counts = new int[common.length];
        for (int i=0; i < plays.length; i++){
            /*This will check out every play in .txt format and check for common words.
             * If we do not have the txt files above in the root folder, we will have to specify
             * the folder in the "" space given before plays[i]:
             */
            FileResource resource = new FileResource("" + plays[i]);
            //We will do that by calling the countWords method:
            countWords(resource,common,counts);
            //We print the plays checked for testing purposes.
            System.out.println("done with " + plays[i]);
        }
        
        for (int i=0; i < common.length; i++){
            //This will print a list with every common word and every count
            System.out.println(common[i] + "\t" + counts[i]);
        }
    }
}
