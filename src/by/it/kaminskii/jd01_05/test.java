package by.it.kaminskii.jd01_05;

public class test {
    public static void main(String[] args) {
        int[][] one = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}};
        System.out.println("╔═════════╦═══════════╗");
        for (int i = 0; i < one[0].length; i++) {
            {
                for (int j = 0; j < one.length; j++) {
                    int k = i + 1 + j * (one[0].length);

                    System.out.print("║ B[" + k + "]=" + one[j][i] + "  ");
                }
                System.out.println("║");
                if (i != (one[0].length - 1))
                    System.out.println("╠═════════╬═══════════╣");
            }
        }
        System.out.print("╚═════════╩═══════════╝");
    }
}
