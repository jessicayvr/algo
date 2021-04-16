package amazon;

import java.util.*;

public class reOrderLogFile {

    public static void main(String[] args) {
        String[] files = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] reorder = reorder(files);
        System.out.println(reorder.toString());
    }

    private static String[] reorder(String[] files) {
        List<String> digitList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String[] log = file.split(" ");
            char firstCharacter = log[1].charAt(0);
            if (Character.isDigit(firstCharacter)) {
                digitList.add(file);
            } else {
                stringList.add(file);
            }
        }

        stringList.sort(Comparator.comparing(s -> {
            String[] s1 = s.split(" ");
            return s1[1];
        }));

       List<String> result = new ArrayList<>();
       result.addAll(stringList);
       result.addAll(digitList);
       return result.stream().toArray(String[]::new);
    }

}

