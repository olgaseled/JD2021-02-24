
package by.it.khrolovich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum states {
    one(),//one->one()просто текст, значит идем до слэы
    two(),//после слэш текст значит опять ищем слэш
    tree(),//после слэш ещё один слэш значит ищем перевод коретки
    four(),//после слэш *, значит идем до */
    five();//после * опять *, значит идем до */
    private String currentState;

    private String gerCurrentState() {
        return currentState;
    }

    private void setCurrentState(String state) {
        this.currentState = state;
    }
}

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
        Stream<String> lines = null;
        StringBuilder sb = new StringBuilder();
        //sb.append("привет").append('\n').append("//привет").append('\n').append("/*привет*/");

        try {
            Files.lines(Paths.get(fileName)).forEach(s -> sb.append(s).append('\n'));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        char[] chars = new char[sb.length()];

        sb.getChars(0, sb.length(), chars, 0);
        String s = String.copyValueOf(chars);
        int start = 0;
        int end = 0;
        int position = 0;
        int countOfDel = 0;
        boolean isCommentSimple = false;
        boolean isCommentMulti = false;
        int currentInd = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '/':
                    if (start == 0) {
                        start = currentInd;//подозреваем комментарий
                    } else {
                        if (start == currentInd - 1) {//нашли комментарий
                            isCommentSimple = true;

                        }else{
                            if ((s.charAt(currentInd - 1) == '*') && isCommentMulti){
                                end = currentInd;
                            }
                        }
                    }
                    break;
                case '*':
                    if (start == currentInd - 1) {//нашли комментарий
                        isCommentMulti = true;
                    }
                    break;
                case '\n':
                    if (isCommentSimple) {
                        end = currentInd-1;
                    }
                    break;
                default: if (start == currentInd - 1){start =0;}
                    ;
            }
            if (start != 0 && end != 0) {
                sb.replace(start-position, end-position+1, "");
                countOfDel++;
                isCommentSimple = false;
                isCommentMulti = false;
                //currentInd = start;
                if(countOfDel==1) {
                    //System.out.println(countOfDel);
                };
                position =position+ (end-start+1);
                start = 0;
                end = 0;
                //break;
            }
            currentInd++;

        }
        System.out.println(sb.toString());
        try(PrintWriter pw =new PrintWriter(fileNameTXT)){
            pw.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**delete this comment
     *
     * @param args
     */
}
