import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    public static void main(String[] args) {

        List<String> anagram = new ArrayList<>();
        anagram.add("ratti");
        anagram.add("ratai");
        anagram.add("enlists");
        anagram.add("banana");
        anagram.add("google");
        anagram.add("listet");
        anagram.add("trita");
        anagram.add("ratai");
        anagram.add("tatri");
        String reference = "trita";
        List<String> anagramClone = new ArrayList<>();


        for(String s : isAnagram(anagram, reference)) {
            System.out.println(s);
        }

    }
    public static List<String> isAnagram(List<String> list, String reference) {
        List<String> copiedAnagram = new ArrayList<>();
        for(String s : list) {
            String reference2 = reference.replaceAll("\\s", "");
            String s2 = s.replaceAll("\\s", "");
            if(reference2.length() == s2.length()) {
                char[] listStringArr = s2.toCharArray();
                char[] referenceArr = reference2.toCharArray();
                Arrays.sort(listStringArr);
                Arrays.sort(referenceArr);
                if(Arrays.equals(listStringArr, referenceArr)) {
                    copiedAnagram.add(s);
                }
            }
        }
        return copiedAnagram;
    }
}
