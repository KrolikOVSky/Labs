package Lab6;

import java.util.*;

public class Main {

    private static void printArray(Object[] arr) {
        for (var a : arr) {
            if (a != null && a != "") System.out.printf("\"%s\" ", a);
        }
        System.out.println("\n");
    }

    private static String replacement(String string, char oldChar, char newChar) {
        var result = "";
        for (var letter : string.toCharArray()) {
            if (letter == oldChar) result += newChar;
            else result += letter;
        }
        return result;
    }

    public static void main(String[] args) {
        Sentence sentence = new Sentence("  А   Алиса  спрятала    ключик под    коврик  ");
        System.out.printf("Main sentence: \"%s\"\n", sentence);
        System.out.print("Words from sentence: ");
        printArray(sentence.getWords());
        int length = 3;
        System.out.printf("Words with first up case letter and length above %d: %s\n\n", length, sentence.upCaseAndLengthAboveN(length));
        var string = "ананас";
        System.out.printf("Original string: %s\nFirst replacement \"а\" -> \"е\": %s\nSecond replacement \"н\" -> \"t\": %s\n", string, replacement(string, 'а', 'е'), replacement(string, 'н', 't'));
    }
}
