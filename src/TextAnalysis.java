// Import classes that can help analyze text files
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


//This class will analyze text
public class TextAnalysis {
    private static ArrayList<Article> articles;
    private static final ArrayList<String> biasedWords = new ArrayList<String>(Arrays.asList("Democratic"
    , "bad", "personally", "illegal", "woman", "single", "rich", "corruption", "administration", "americans", "conservative", "doubt", "torture",
    "doing", "illegal","stop", "tax", "claimed", "human", "doesnt", "difficult", "democrats", "less", "pass", "bad", "sure", "blame", "theyre", "happen", "death",
            "actually", "exactly", "wrong", "corporation", "wealthy", "politics", "Xenophobia" ));

    public static void main(String[] args){
        articles = new ArrayList<Article> ();
        initialize();
        loopArticles();
        printPercentages();

    }

    //Initialize all the articles

    public static void loopArticles(){
        for(int i = 0; i < articles.size(); i++){
            System.out.println("ARTICLE " + (i + 1));
            File myObj = new File(articles.get(i).getPathName());
            try {
                Scanner myReader = new Scanner(myObj);
                while(myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    String[] words = data.split(" ");
                    loopText(words, articles.get(i));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(articles.get(i).getBiasScore());
            System.out.println(articles.get(i).getTotalWords());
            System.out.println();
        }
    }

    public static void loopText(String [] word, Article currentArticle){
        for(int i = 0; i < word.length; i++){
            String currentWord = extractWord(word[i]);
            for(int j = 0; j < biasedWords.size(); j++){
                if(currentWord.equals(biasedWords.get(j))){
                    currentArticle.incrementBiasScore();
                    System.out.println("Word that is biased: " + currentWord);
                }
            }
            currentArticle.incrementWords();
        }
    }

    public static String extractWord(String word){
        String[] words = word.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        return words[0];
    }

    public static void printPercentages(){
        for(int i = 0; i < articles.size(); i++){
            double percent = (( (double) articles.get(i).getBiasScore()) / ( (double)articles.get(i).getTotalWords())) * 100;
            System.out.println("ARTICLE " + i + " Percent: " + percent);
        }
    }

    public static void initialize(){
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File1.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File2.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File3.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File4.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File5.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File6.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File7.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File8.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File9.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File10.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File11.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File12.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File13.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File14.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File15.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File16.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File17.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File18.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File19.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File20.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File21.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File22.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File23.txt", 2000));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File24.txt", 2000));

        articles.add(new Article("D:\\2001\\File25.txt", 2001));
        articles.add(new Article("D:\\2001\\File26.txt", 2001));
        articles.add(new Article("D:\\2001\\File27.txt", 2001));
        articles.add(new Article("D:\\2001\\File28.txt", 2001));
        articles.add(new Article("D:\\2001\\File29.txt", 2001));
        articles.add(new Article("D:\\2001\\File30.txt", 2001));
        articles.add(new Article("D:\\2001\\File31.txt", 2001));
        articles.add(new Article("D:\\2001\\File32.txt", 2001));
        articles.add(new Article("D:\\2001\\File33.txt", 2001));
        articles.add(new Article("D:\\2001\\File34.txt", 2001));
        articles.add(new Article("D:\\2001\\File35.txt", 2001));
        articles.add(new Article("D:\\2001\\File36.txt", 2001));
        articles.add(new Article("D:\\2001\\File37.txt", 2001));
        articles.add(new Article("D:\\2001\\File38.txt", 2001));
        articles.add(new Article("D:\\2001\\File39.txt", 2001));
        articles.add(new Article("D:\\2001\\File40.txt", 2001));
        articles.add(new Article("D:\\2001\\File41.txt", 2001));
        articles.add(new Article("D:\\2001\\File42.txt", 2001));
        articles.add(new Article("D:\\2001\\File43.txt", 2001));
        articles.add(new Article("D:\\2001\\File44.txt", 2001));
        articles.add(new Article("D:\\2001\\File45.txt", 2001));
        articles.add(new Article("D:\\2001\\File46.txt", 2001));
        articles.add(new Article("D:\\2001\\File47.txt", 2001));
        articles.add(new Article("D:\\2001\\File48.txt", 2001));

        articles.add(new Article("D:\\2002\\File49.txt", 2002));
        articles.add(new Article("D:\\2002\\File50.txt", 2002));
        articles.add(new Article("D:\\2002\\File51.txt", 2002));
        articles.add(new Article("D:\\2002\\File52.txt", 2002));
        articles.add(new Article("D:\\2002\\File53.txt", 2002));
        articles.add(new Article("D:\\2002\\File54.txt", 2002));
        articles.add(new Article("D:\\2002\\File55.txt", 2002));
        articles.add(new Article("D:\\2002\\File56.txt", 2002));
        articles.add(new Article("D:\\2002\\File57.txt", 2002));
        articles.add(new Article("D:\\2002\\File58.txt", 2002));
        articles.add(new Article("D:\\2002\\File59.txt", 2002));
        articles.add(new Article("D:\\2002\\File60.txt", 2002));
        articles.add(new Article("D:\\2002\\File61.txt", 2002));
        articles.add(new Article("D:\\2002\\File62.txt", 2002));
        articles.add(new Article("D:\\2002\\File63.txt", 2002));
        articles.add(new Article("D:\\2002\\File64.txt", 2002));
        articles.add(new Article("D:\\2002\\File65.txt", 2002));
        articles.add(new Article("D:\\2002\\File66.txt", 2002));
        articles.add(new Article("D:\\2002\\File67.txt", 2002));
        articles.add(new Article("D:\\2002\\File68.txt", 2002));
        articles.add(new Article("D:\\2002\\File69.txt", 2002));
        articles.add(new Article("D:\\2002\\File70.txt", 2002));
        articles.add(new Article("D:\\2002\\File71.txt", 2002));
        articles.add(new Article("D:\\2002\\File72.txt", 2002));


    }

}
