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
    public static void initialize(){
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File1.txt", 2001));
        articles.add(new Article("C:\\Users\\amanm\\Desktop\\AP Research\\File2.txt", 2001));
    }

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
}
