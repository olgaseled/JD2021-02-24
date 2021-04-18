package by.it.levchuk.levchuk.jd01_15;
/*crash-noobik
Liauchuk Aliaksandr*/

public class Conditions {

    public static final String JAVA_TASK = "TaskB.java";
    public static final String TXT_TASK = "TaskB.txt";
    public static final int MAX = 10000;

    public static void delJavaDocComments(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char slesh = '/', star = '*';
        int previous = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if ((1 <= j) && (lineChars[j - 1] == slesh) & (lineChars[j] == star)) {
                previous = j - 1;
                break;
            }
        }
        stringBuffer.setLength(0);
    }

    public static int delStartLine(StringBuffer[] strBuf, int i, boolean del) {
        for (; !strBuf[i].toString().contains("*/"); i++) {
            strBuf[i].setLength(0);
            String endString = "";
            if (del) {
                endString = "";
            } else {
                endString = "\n";
            }
            strBuf[i].append(endString);
        }
        int newI = i;
        return newI;
    }

    public static void delStopLine(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char slesh = '/', star = '*';
        int stopSing = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if ((1 <= j) && (lineChars[j - 1] == star) & (lineChars[j] == slesh)) {
                stopSing = j + 1;
            }
        }
        stringBuffer.setLength(0);
    }

    public static void delSingleComments(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char previous = '/';
        int startSing = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if (lineChars[j] == previous) {
                startSing = j;
                break;
            }
        }
        stringBuffer.setLength(0);
    }

    public static void delBlockComments(StringBuffer stringBuffer) {
        char[] lineChars = stringBuffer.toString().toCharArray();
        char slesh = '/', star = '*';
        int startSing = -1;
        int stopSing = -1;
        for (int j = 0; j < lineChars.length; j++) {
            if ((1 <= j) && (lineChars[j - 1] == slesh) & (lineChars[j] == star)) {
                startSing = j - 1;
            } else if ((1 <= j) && (lineChars[j - 1] == star) & (lineChars[j] == slesh)) {
                stopSing = j + 1;
            }
        }
        stringBuffer.setLength(0);
    }

}

