package by.it.dudko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        final String delimiter = "\n";
        String[] textRows = Helper.splitTextByCharacter(new StringBuilder(Poem.text), delimiter);
        int rowLength = getMaxStringLength(textRows);
        justifyTextRows(textRows, rowLength);
        String justifiedText = String.join(delimiter, textRows);
        System.out.println(justifiedText);
    }

    private static int getMaxStringLength(String[] textRows) {
        int maxLength = 0;
        for (int i = 0; i < textRows.length; i++) {
            int stringLength = textRows[i].length();
            if (maxLength < stringLength) {
                maxLength = stringLength;
            }
        }
        return maxLength;
    }

    private static void justifyTextRows(String[] textRow, int rowLength) {
        for (int i = 0; i < textRow.length; i++) {
            String initialString = textRow[i].trim();
            int additionalSpaces = rowLength - initialString.length();
            StringBuilder justifiedString = new StringBuilder(initialString);
            int startOfSearchRange = 0;
//            while (additionalSpaces > 0) {
//                startOfSearchRange = (startOfSearchRange > justifiedString.length()) ? justifiedString.indexOf(" ");
//                int insertPosition = justifiedString.indexOf(" ", startOfSearchRange) + 1;
//                justifiedString.insert(insertPosition, ' ');
//                startOfSearchRange = insertPosition + 1;
//                additionalSpaces--;
//            }
//            textRow[i] = justifiedString.toString();
            Pattern pattern = Pattern.compile(" +");
            Matcher matcher = pattern.matcher(justifiedString);
            while (additionalSpaces > 0) {
                if (matcher.find(startOfSearchRange)) {
                    int insertPosition = matcher.end();
                    justifiedString.insert(insertPosition, ' ');
                    startOfSearchRange = insertPosition + 1;
                    additionalSpaces--;
                } else {
                    startOfSearchRange = 0;
                }
            }
            textRow[i] = justifiedString.toString();
        }
    }

}
