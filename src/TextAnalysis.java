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
    private static  ArrayList<Word> biasedWords ;



    public static void main(String[] args){
        articles = new ArrayList<Article> ();
        initialize();
        addWords();
        loopArticles();
        printPercentages();
        printWords();

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

        }
    }

    private static void addWords(){
        Word democratic = new Word("democratic");
        Word bad = new Word("bad");
        Word personally = new Word("personally");
        Word illegal = new Word("illegal");
        Word woman = new Word("woman");
        Word single = new Word("single");
        Word rich = new Word("rich");
        Word corruption = new Word("corruption");
        Word administration = new Word("administration");
        Word americans = new Word("americans");
        Word conservative = new Word("conservative");
        Word doubt = new Word("doubt");
        Word torture = new Word("torture");
        Word doing = new Word("doing");

        Word lobbyist = new Word("lobbyist");
        Word republican = new Word("republican");
        Word union = new Word("union");
        Word interest = new Word("interest");


        Word stop = new Word("stop");
        Word tax = new Word("tax");
        Word claimed = new Word("claimed");
        Word human = new Word("human");
        Word doesnt = new Word("doesnt");
        Word difficult = new Word("difficult");
        Word democrats = new Word("democrats");
        Word less = new Word("less");
        Word pass = new Word("pass");
        Word sure = new Word("sure");
        Word blame = new Word("blame");
        Word theyre = new Word("theyre");

        Word happen = new Word("happen");
        Word death = new Word("death");
        Word actually = new Word("actually");
        Word exactly = new Word("exactly");
        Word wrong = new Word("wrong");
        Word corporation = new Word("corporation");
        Word wealthy = new Word("wealthy");
        Word politics = new Word("politics");
        Word xenophobia = new Word("xenophobia");

         biasedWords = new ArrayList<Word>(Arrays.asList(
                democratic,  bad ,  personally ,  illegal ,  woman ,  single ,  rich ,  corruption ,
                administration,  americans ,  conservative ,  doubt ,  torture ,
                doing ,  illegal , stop ,  tax ,  claimed ,  human ,  doesnt ,  difficult ,
                democrats ,  less ,  pass ,  bad ,  sure ,  blame ,  theyre ,
                happen ,  death , actually ,  exactly ,  wrong ,  corporation ,
                wealthy ,  politics ,  xenophobia, lobbyist, republican, union, interest  ));

    }

    public static void loopText(String [] word, Article currentArticle){
        for(int i = 0; i < word.length; i++){
            String currentWord = extractWord(word[i]);
            for(int j = 0; j < biasedWords.size(); j++){
                if(currentWord.equals(biasedWords.get(j).getWord())){
                    currentArticle.incrementBiasScore();
                    biasedWords.get(j).incrementWord();
                    System.out.println("Word that is biased: " + currentWord);
                }
            }
            currentArticle.incrementWords();
        }
    }

    public static void printWords(){
        int total = 0;
        for(int i = 0; i < biasedWords.size(); i++){
            System.out.println(biasedWords.get(i).getTotalWords());
            total += biasedWords.get(i).getTotalWords();
        }

        double hey = 0.0;

        for(int j = 0; j < biasedWords.size(); j++){
            hey = ((double) biasedWords.get(j).getTotalWords() / (double) total);
            System.out.println(biasedWords.get(j).getWord() + ":" + String.format("%.2f", hey));
        }

    }
    public static String extractWord(String word){
        String[] words = word.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        return words[0];
    }

    public static void printPercentages(){
        for(int i = 0; i < articles.size(); i++){
            double percent = (( (double) articles.get(i).getBiasScore()) / ( (double)articles.get(i).getTotalWords())) * 100;
            System.out.println(String.format("%.2f", percent));
        }
    }

    public static void initialize(){
        articles.add(new Article("D:\\2000\\File1.txt", 2000));
        articles.add(new Article("D:\\2000\\File2.txt", 2000));
        articles.add(new Article("D:\\2000\\File3.txt", 2000));
        articles.add(new Article("D:\\2000\\File4.txt", 2000));
        articles.add(new Article("D:\\2000\\File5.txt", 2000));
        articles.add(new Article("D:\\2000\\File6.txt", 2000));
        articles.add(new Article("D:\\2000\\File7.txt", 2000));
        articles.add(new Article("D:\\2000\\File8.txt", 2000));
        articles.add(new Article("D:\\2000\\File9.txt", 2000));
        articles.add(new Article("D:\\2000\\File10.txt", 2000));
        articles.add(new Article("D:\\2000\\File11.txt", 2000));
        articles.add(new Article("D:\\2000\\File12.txt", 2000));


        articles.add(new Article("D:\\2001\\File1.txt", 2001));
        articles.add(new Article("D:\\2001\\File2.txt", 2001));
        articles.add(new Article("D:\\2001\\File3.txt", 2001));
        articles.add(new Article("D:\\2001\\File4.txt", 2001));
        articles.add(new Article("D:\\2001\\File5.txt", 2001));
        articles.add(new Article("D:\\2001\\File6.txt", 2001));
        articles.add(new Article("D:\\2001\\File7.txt", 2001));
        articles.add(new Article("D:\\2001\\File8.txt", 2001));
        articles.add(new Article("D:\\2001\\File9.txt", 2001));
        articles.add(new Article("D:\\2001\\File10.txt", 2001));
        articles.add(new Article("D:\\2001\\File11.txt", 2001));
        articles.add(new Article("D:\\2001\\File12.txt", 2001));


        articles.add(new Article("D:\\2002\\File1.txt", 2002));
        articles.add(new Article("D:\\2002\\File2.txt", 2002));
        articles.add(new Article("D:\\2002\\File3.txt", 2002));
        articles.add(new Article("D:\\2002\\File4.txt", 2002));
        articles.add(new Article("D:\\2002\\File5.txt", 2002));
        articles.add(new Article("D:\\2002\\File6.txt", 2002));
        articles.add(new Article("D:\\2002\\File7.txt", 2002));
        articles.add(new Article("D:\\2002\\File8.txt", 2002));
        articles.add(new Article("D:\\2002\\File9.txt", 2002));
        articles.add(new Article("D:\\2002\\File10.txt", 2002));
        articles.add(new Article("D:\\2002\\File11.txt", 2002));
        articles.add(new Article("D:\\2002\\File12.txt", 2002));



        articles.add(new Article("D:\\2003\\File1.txt", 2003));
        articles.add(new Article("D:\\2003\\File2.txt", 2003));
        articles.add(new Article("D:\\2003\\File3.txt", 2003));
        articles.add(new Article("D:\\2003\\File4.txt", 2003));
        articles.add(new Article("D:\\2003\\File5.txt", 2003));
        articles.add(new Article("D:\\2003\\File6.txt", 2003));
        articles.add(new Article("D:\\2003\\File7.txt", 2003));
        articles.add(new Article("D:\\2003\\File8.txt", 2003));
        articles.add(new Article("D:\\2003\\File9.txt", 2003));
        articles.add(new Article("D:\\2003\\File10.txt", 2003));
        articles.add(new Article("D:\\2003\\File11.txt", 2003));
        articles.add(new Article("D:\\2003\\File12.txt", 2003));



        articles.add(new Article("D:\\2004\\File1.txt", 2004));
        articles.add(new Article("D:\\2004\\File2.txt", 2004));
        articles.add(new Article("D:\\2004\\File3.txt", 2004));
        articles.add(new Article("D:\\2004\\File4.txt", 2004));
        articles.add(new Article("D:\\2004\\File5.txt", 2004));
        articles.add(new Article("D:\\2004\\File6.txt", 2004));
        articles.add(new Article("D:\\2004\\File7.txt", 2004));
        articles.add(new Article("D:\\2004\\File8.txt", 2004));
        articles.add(new Article("D:\\2004\\File9.txt", 2004));
        articles.add(new Article("D:\\2004\\File10.txt", 2004));
        articles.add(new Article("D:\\2004\\File11.txt", 2004));
        articles.add(new Article("D:\\2004\\File12.txt", 2004));


        articles.add(new Article("D:\\2005\\File1.txt", 2005));
        articles.add(new Article("D:\\2005\\File2.txt", 2005));
        articles.add(new Article("D:\\2005\\File3.txt", 2005));
        articles.add(new Article("D:\\2005\\File4.txt", 2005));
        articles.add(new Article("D:\\2005\\File5.txt", 2005));
        articles.add(new Article("D:\\2005\\File6.txt", 2005));
        articles.add(new Article("D:\\2005\\File7.txt", 2005));
        articles.add(new Article("D:\\2005\\File8.txt", 2005));
        articles.add(new Article("D:\\2005\\File9.txt", 2005));
        articles.add(new Article("D:\\2005\\File10.txt", 2005));
        articles.add(new Article("D:\\2005\\File11.txt", 2005));
        articles.add(new Article("D:\\2005\\File12.txt", 2005));


        articles.add(new Article("D:\\2006\\File1.txt", 2006));
        articles.add(new Article("D:\\2006\\File2.txt", 2006));
        articles.add(new Article("D:\\2006\\File3.txt", 2006));
        articles.add(new Article("D:\\2006\\File4.txt", 2006));
        articles.add(new Article("D:\\2006\\File5.txt", 2006));
        articles.add(new Article("D:\\2006\\File6.txt", 2006));
        articles.add(new Article("D:\\2006\\File7.txt", 2006));
        articles.add(new Article("D:\\2006\\File8.txt", 2006));
        articles.add(new Article("D:\\2006\\File9.txt", 2006));
        articles.add(new Article("D:\\2006\\File10.txt", 2006));
        articles.add(new Article("D:\\2006\\File11.txt", 2006));
        articles.add(new Article("D:\\2006\\File12.txt", 2006));


        articles.add(new Article("D:\\2007\\File1.txt", 2007));
        articles.add(new Article("D:\\2007\\File2.txt", 2007));
        articles.add(new Article("D:\\2007\\File3.txt", 2007));
        articles.add(new Article("D:\\2007\\File4.txt", 2007));
        articles.add(new Article("D:\\2007\\File5.txt", 2007));
        articles.add(new Article("D:\\2007\\File6.txt", 2007));
        articles.add(new Article("D:\\2007\\File7.txt", 2007));
        articles.add(new Article("D:\\2007\\File8.txt", 2007));
        articles.add(new Article("D:\\2007\\File9.txt", 2007));
        articles.add(new Article("D:\\2007\\File10.txt", 2007));
        articles.add(new Article("D:\\2007\\File11.txt", 2007));
        articles.add(new Article("D:\\2007\\File12.txt", 2007));



        articles.add(new Article("D:\\2008\\File1.txt", 2008));
        articles.add(new Article("D:\\2008\\File2.txt", 2008));
        articles.add(new Article("D:\\2008\\File3.txt", 2008));
        articles.add(new Article("D:\\2008\\File4.txt", 2008));
        articles.add(new Article("D:\\2008\\File5.txt", 2008));
        articles.add(new Article("D:\\2008\\File6.txt", 2008));
        articles.add(new Article("D:\\2008\\File7.txt", 2008));
        articles.add(new Article("D:\\2008\\File8.txt", 2008));
        articles.add(new Article("D:\\2008\\File9.txt", 2008));
        articles.add(new Article("D:\\2008\\File10.txt", 2008));
        articles.add(new Article("D:\\2008\\File11.txt", 2008));
        articles.add(new Article("D:\\2008\\File12.txt", 2008));



        articles.add(new Article("D:\\2009\\File1.txt", 2009));
        articles.add(new Article("D:\\2009\\File2.txt", 2009));
        articles.add(new Article("D:\\2009\\File3.txt", 2009));
        articles.add(new Article("D:\\2009\\File4.txt", 2009));
        articles.add(new Article("D:\\2009\\File5.txt", 2009));
        articles.add(new Article("D:\\2009\\File6.txt", 2009));
        articles.add(new Article("D:\\2009\\File7.txt", 2009));
        articles.add(new Article("D:\\2009\\File8.txt", 2009));
        articles.add(new Article("D:\\2009\\File9.txt", 2009));
        articles.add(new Article("D:\\2009\\File10.txt", 2009));
        articles.add(new Article("D:\\2009\\File11.txt", 2009));
        articles.add(new Article("D:\\2009\\File12.txt", 2009));



        articles.add(new Article("D:\\2010\\File1.txt", 2010));
        articles.add(new Article("D:\\2010\\File2.txt", 2010));
        articles.add(new Article("D:\\2010\\File3.txt", 2010));
        articles.add(new Article("D:\\2010\\File4.txt", 2010));
        articles.add(new Article("D:\\2010\\File5.txt", 2010));
        articles.add(new Article("D:\\2010\\File6.txt", 2010));
        articles.add(new Article("D:\\2010\\File7.txt", 2010));
        articles.add(new Article("D:\\2010\\File8.txt", 2010));
        articles.add(new Article("D:\\2010\\File9.txt", 2010));
        articles.add(new Article("D:\\2010\\File10.txt", 2010));
        articles.add(new Article("D:\\2010\\File11.txt", 2010));
        articles.add(new Article("D:\\2010\\File12.txt", 2010));


        articles.add(new Article("D:\\2011\\File1.txt", 2011));
        articles.add(new Article("D:\\2011\\File2.txt", 2011));
        articles.add(new Article("D:\\2011\\File3.txt", 2011));
        articles.add(new Article("D:\\2011\\File4.txt", 2011));
        articles.add(new Article("D:\\2011\\File5.txt", 2011));
        articles.add(new Article("D:\\2011\\File6.txt", 2011));
        articles.add(new Article("D:\\2011\\File7.txt", 2011));
        articles.add(new Article("D:\\2011\\File8.txt", 2011));
        articles.add(new Article("D:\\2011\\File9.txt", 2011));
        articles.add(new Article("D:\\2011\\File10.txt", 2011));
        articles.add(new Article("D:\\2011\\File11.txt", 2011));
        articles.add(new Article("D:\\2011\\File12.txt", 2011));

        articles.add(new Article("D:\\2012\\File1.txt", 2012));
        articles.add(new Article("D:\\2012\\File2.txt", 2012));
        articles.add(new Article("D:\\2012\\File3.txt", 2012));
        articles.add(new Article("D:\\2012\\File4.txt", 2012));
        articles.add(new Article("D:\\2012\\File5.txt", 2012));
        articles.add(new Article("D:\\2012\\File6.txt", 2012));
        articles.add(new Article("D:\\2012\\File7.txt", 2012));
        articles.add(new Article("D:\\2012\\File8.txt", 2012));
        articles.add(new Article("D:\\2012\\File9.txt", 2012));
        articles.add(new Article("D:\\2012\\File10.txt", 2012));
        articles.add(new Article("D:\\2012\\File11.txt", 2012));
        articles.add(new Article("D:\\2012\\File12.txt", 2012));

        articles.add(new Article("D:\\2013\\File1.txt", 2013));
        articles.add(new Article("D:\\2013\\File2.txt", 2013));
        articles.add(new Article("D:\\2013\\File3.txt", 2013));
        articles.add(new Article("D:\\2013\\File4.txt", 2013));
        articles.add(new Article("D:\\2013\\File5.txt", 2013));
        articles.add(new Article("D:\\2013\\File6.txt", 2013));
        articles.add(new Article("D:\\2013\\File7.txt", 2013));
        articles.add(new Article("D:\\2013\\File8.txt", 2013));
        articles.add(new Article("D:\\2013\\File9.txt", 2013));
        articles.add(new Article("D:\\2013\\File10.txt", 2013));
        articles.add(new Article("D:\\2013\\File11.txt", 2013));
        articles.add(new Article("D:\\2013\\File12.txt", 2013));

        articles.add(new Article("D:\\2014\\File1.txt", 2014));
        articles.add(new Article("D:\\2014\\File2.txt", 2014));
        articles.add(new Article("D:\\2014\\File3.txt", 2014));
        articles.add(new Article("D:\\2014\\File4.txt", 2014));
        articles.add(new Article("D:\\2014\\File5.txt", 2014));
        articles.add(new Article("D:\\2014\\File6.txt", 2014));
        articles.add(new Article("D:\\2014\\File7.txt", 2014));
        articles.add(new Article("D:\\2014\\File8.txt", 2014));
        articles.add(new Article("D:\\2014\\File9.txt", 2014));
        articles.add(new Article("D:\\2014\\File10.txt", 2014));
        articles.add(new Article("D:\\2014\\File11.txt", 2014));
        articles.add(new Article("D:\\2014\\File12.txt", 2014));

        articles.add(new Article("D:\\2015\\File1.txt", 2015));
        articles.add(new Article("D:\\2015\\File2.txt", 2015));
        articles.add(new Article("D:\\2015\\File3.txt", 2015));
        articles.add(new Article("D:\\2015\\File4.txt", 2015));
        articles.add(new Article("D:\\2015\\File5.txt", 2015));
        articles.add(new Article("D:\\2015\\File6.txt", 2015));
        articles.add(new Article("D:\\2015\\File7.txt", 2015));
        articles.add(new Article("D:\\2015\\File8.txt", 2015));
        articles.add(new Article("D:\\2015\\File9.txt", 2015));
        articles.add(new Article("D:\\2015\\File10.txt", 2015));
        articles.add(new Article("D:\\2015\\File11.txt", 2015));
        articles.add(new Article("D:\\2015\\File12.txt", 2015));

        articles.add(new Article("D:\\2016\\File1.txt", 2016));
        articles.add(new Article("D:\\2016\\File2.txt", 2016));
        articles.add(new Article("D:\\2016\\File3.txt", 2016));
        articles.add(new Article("D:\\2016\\File4.txt", 2016));
        articles.add(new Article("D:\\2016\\File5.txt", 2016));
        articles.add(new Article("D:\\2016\\File6.txt", 2016));
        articles.add(new Article("D:\\2016\\File7.txt", 2016));
        articles.add(new Article("D:\\2016\\File8.txt", 2016));
        articles.add(new Article("D:\\2016\\File9.txt", 2016));
        articles.add(new Article("D:\\2016\\File10.txt", 2016));
        articles.add(new Article("D:\\2016\\File11.txt", 2016));
        articles.add(new Article("D:\\2016\\File12.txt", 2016));













    }

}
