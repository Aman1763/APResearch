public class Article {
    private String pathname;
    private int year;
    private int biasScore;

    public Article(String path, int y){
        pathname = path;
        year = y;
        biasScore = 0;
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

}
