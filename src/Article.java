public class Article {
    private String pathname;
    private int year;
    private int biasScore;
    private String articleName;
    private int totalWords;

    public Article(String path, int y){
        pathname = path;
        year = y;
        biasScore = 0;
        //articleName = name;
        totalWords = 0;
    }

    public String getPathName(){
        return pathname;
    }

    public void incrementBiasScore(){
        biasScore++;
    }

    public int getBiasScore(){
        return biasScore;
    }
    public int getYear(){
        return year;
    }
    public void incrementWords(){totalWords ++; }

    public int getTotalWords(){return totalWords; }

}
