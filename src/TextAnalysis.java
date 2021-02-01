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
    "doing"));

    public static void main(String[] args){
        articles = new ArrayList<Article> ();
        initialize();
        loopArticles();

    }

    //Initialize all the articles

    public static void loopArticles(){
        for(int i = 0; i < articles.size(); i++){
            System.out.println("YEAR " + i);
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
        }
    }

    public static void loopText(String [] word, Article currentArticle){
        for(int i = 0; i < word.length; i++){
            String currentWord = extractWord(word[i]);
            for(int j = 0; j < biasedWords.size(); j++){
                if(currentWord.equals(biasedWords.get(j))){
                    currentArticle.incrementBiasScore();
                    System.out.println("YES");
                }
            }
        }
    }

    public static String extractWord(String word){
        String[] words = word.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        return words[0];
    }

    public static void initialize(){
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File1.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File2.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File3.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File4.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File5.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File6.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File7.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File8.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File9.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File10.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File11.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File12.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File13.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File14.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File15.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File16.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File17.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File18.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File19.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File20.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File21.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File22.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File23.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File24.txt", 2001));

    }

}
