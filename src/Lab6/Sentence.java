package Lab6;

import java.util.*;

public class Sentence {
    private String string;
    private String[] words;
    private int counter;
    public final static int МАХ_NUM_OF_WORDS = 20;

    public Sentence() {
        this.string = "";
        this.words = null;
        this.counter = 0;
    }

    public Sentence(String string) {
        setString(string);
    }

    public void setString(String string) {
        this.string = string.trim();
        if (string.equals("")) {
            this.words = null;
            this.counter = 0;
        } else splitIntoWords();
    }

    public String[] getWords() {
        return words;
    }

    public String toString() {
        return string;
    }

    public int getCounter() {
        return counter;
    }

    private void splitIntoWords() {
        this.words = new String[МАХ_NUM_OF_WORDS];
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
            System.out.println("В предложении слишком много слов, лишние придется обрезать: " + "\n" + e.getMessage());
            System.out.println();
            counter--;
        }
        counter++;

    }

    public String[] wordsLengthAboveN(int N) {
        if (counter == 0)
            return null;
        String[] arr = new String[counter];
        int j = 0;
        for (int i = 0; i < counter; i++)
            if (words[i].length() > N) {
                arr[j] = words[i];
                j = j + 1;
            }
        return Arrays.stream(arr).filter(Objects::nonNull).toArray(String[]::new);
            // Данная операция нужнадля того, чтобы вернуть массив строк без null элементов
    }

    public String upCaseAndLengthAboveN(int N) {
        StringBuilder string = new StringBuilder();
        for (var str : wordsLengthAboveN(N)) {
            if (str != null && Character.isUpperCase(str.charAt(0))) string.append(String.format("%s ", str));
        }
        return string.toString();
    }

}
