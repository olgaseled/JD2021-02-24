package by.it.seledtsova2.jd01_07;

 class Scalar extends Var {

     private  final double value;

     Scalar(double value) {
         this.value = value;
     }

     Scalar (Scalar otherScalar) {
         this.value=otherScalar.value;
     }

     Scalar (String strScalar) {
         this.value=Double.parseDouble(strScalar);
     }




     @Override
     public String toString() {
         return Double.toString(value);
     }
 }
