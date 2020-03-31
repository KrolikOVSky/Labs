package Lab6;

public class Sentence {
    private String string;
    private String[] words;
    private int counter;
    private final static int МАХ_NUM_OF_WORDS = 20;

    public Sentence() {

    }

    public void setString(String string) {
        this.string = string.trim();
        if (string.equals("")) {
            this.words = null;
            this.counter = 0;
        } else splitIntoWords();
    }

    private void splitIntoWords() {
        words = new String[МАХ_NUM_OF_WORDS];
        int start, end;
        counter = 0;
        start = 0;
        end = string.indexOf(" ");
        try {
            while (end > 0) {
                words[counter] = string.substring(start, end);
                counter++;
                while (string.charAt(end) == ' ') end++;
                start = end;
                end = string.indexOf(" ", start);
            }
            words[counter] = string.substring(start);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("В предложении слишком много слов, лишние придется обрезать: " + "\n" + e);
            System.out.println();
            counter--;
        }
        counter++;

    }

    public String[] getWords() {
        return words;
    }

    @Override
    public String toString() {
        return string;
    }

    public int getCounter() {
        return counter;
    }

    public String[] fixedLength(String string, int length) {
        String[] str = string.trim().split(" ");
        return str;
    }

}
