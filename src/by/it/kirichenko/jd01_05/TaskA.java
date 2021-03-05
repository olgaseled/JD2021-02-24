package by.it.kirichenko.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
        
    }

    private static void step1() {
        double x=0.3;
        double a=756.13;
        double part1=Math.cos(Math.pow(x*x+Math.PI/6,5));
        double part2=Math.sqrt(x*Math.pow(a,3));
        double part3=Math.log(a-1.12*x/4);
        double z=part1-part2-part3;
        System.out.printf("При а=%-10.3f x=%f z=%f\n",a,x,z);
    }

    private static void step2() {
        double a=1.21;
        double b=0.371;
        double y=Math.tan(Math.pow(a+b,2))
                -Math.pow(a+1.5,1./3)
                +a*Math.pow(b,5)-b/Math.log(a*a);
        System.out.printf("При а=%-10.3f b=%f y=%f\n",a,b,y);

    }

    private static void step3() {
        double x=12.1;
        for (double a = -5; a <= 12; a+=3.75) {
            double f=Math.exp(a*x)-3.45*a;
            System.out.printf("При а=%-10.3f f=%f\n",a,f);
        }
    }

}
