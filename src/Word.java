public class Word {

        private String word;

        private int totalWords;

        public Word(String path){
            word = path;
            //articleName = name;
            totalWords = 0;
        }

        public void incrementWord(){
            totalWords++;
        }

        public int getTotalWords(){
            return totalWords;
        }
        public String getWord(){
            return word;
        }



}
