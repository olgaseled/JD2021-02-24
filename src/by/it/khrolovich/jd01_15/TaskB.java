
package by.it.khrolovich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*enum states {
    one(),//просто текст, значит идем до слэш
    two(),//после слэш текст, значит опять ищем слэш
    tree(),//после слэш ещё один слэш значит ищем перевод коретки
    four();//после слэш *, значит идем до
    //five();//после * опять *, значит идем до
    private String currentState;

    private String gerCurrentState() {
        return currentState;
    }

    private void setCurrentState(String state) {
        this.currentState = state;
    }
}*/

public class TaskB {
    //delete this comment 1

    /*delete this
    multiLineComment 1
     */

    public static void main(String[] args) {
        //delete this comment 2
        /*delete this
        multiLineComment 2
        */
        String fileName = FileNameHelper.getFilePath("TaskB.java", TaskA.class);
        String fileNameTXT = FileNameHelper.getFilePath("TaskB.txt", TaskA.class);
        System.out.println(fileName);
        StringBuilder sb = new StringBuilder();
        //sb.append("привет").append('\n').append("//привет").append('\n').append("/*привет*/");

        saveToString(fileName, sb);
        deleteComment(sb);
        System.out.println(sb.toString());
        printToFile(fileNameTXT, sb);
    }

    private static void printToFile(String fileNameTXT, StringBuilder sb) {
        try(PrintWriter pw =new PrintWriter(fileNameTXT)){
            pw.write(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteComment(StringBuilder sb) {
        char[] chars = new char[sb.length()];
        sb.getChars(0, sb.length(), chars, 0);
        String s = String.copyValueOf(chars);
        int start = 0;
        int end = 0;
        int position = 0;
        boolean isCommentSimple = false;
        boolean isCommentMulti = false;
        int currentInd = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '/':
                    if (start == 0) {
                        start = currentInd;//may be find simple comment
                    } else {
                        if (start == currentInd - 1) {//find simple comment
                            isCommentSimple = true;

                        }else{
                            if ((s.charAt(currentInd - 1) == '*') && isCommentMulti){
                                end = currentInd;
                            }
                        }
                    }
                    break;
                case '*':
                    if (start == currentInd - 1) {//find multiply comment
                        isCommentMulti = true;
                    }
                    break;
                case '\n':
                    if (isCommentSimple) {//find the end of  simple comment
                        end = currentInd-1;
                    }
                    break;
                default: if (start == currentInd - 1){start =0;}
            }
            //delete comment if find it
            if (start != 0 && end != 0) {
                sb.replace(start-position, end-position+1, "");
                isCommentSimple = false;
                isCommentMulti = false;
                position =position+ (end-start+1);
                start = 0;
                end = 0;
            }
            currentInd++;

        }
    }

    private static void saveToString(String fileName, StringBuilder sb) {
        try {
            Files.lines(Paths.get(fileName)).forEach(s -> sb.append(s).append('\n'));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**delete this comment
     *
     * @param args
     */
}
