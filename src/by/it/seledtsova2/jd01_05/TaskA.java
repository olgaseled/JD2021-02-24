package by.it.seledtsova2.jd01_05;


public class TaskA {
    public static void main(String[] args) {
        stepA1();
        stepA2();
        stepA3();
    }

    private static void stepA3() {
        double x=12.1;
        for (double a=-5 ; a<=12 ; a=a+3.75) {
            double totalStepA3 = (Math.pow(Math.E, a * x)) - (3.45 * a);

            System.out.println("При a= "+a+" ответ такой = "+totalStepA3);
        }
    }

    private static void stepA2() {
        double a=1.21;
        double b=0.371;
        double part1=Math.tan(Math.pow((a+b),2));
        double part2=Math.cbrt(a+1.5);
        double part3=a*(Math.pow(b,5));
        double part4=b/(Math.log(a*a));
        double totalStepA2=part1-part2+part3-part4;
        System.out.println(totalStepA2);
    }

    private static void stepA1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = Math.cos(Math.pow((x * x + Math.PI / 6), 5));
        double part2 = Math.sqrt(x * (Math.pow(a, 3)));
        double part3 = Math.log((a - 1.12 * x) / 4);
        double totalStepA1 = part1 - part2 - part3;
        System.out.println(totalStepA1);
    }

}
