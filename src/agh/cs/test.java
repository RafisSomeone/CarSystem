package agh.cs;
import static java.lang.System.out;
 class TEST {

     public static void main (String[] args)
     {



         boolean invalidValue = true;
         if(invalidValue) {
             System.out.println("Wycieraczki są włączone");
         } else {
             System.out.println("Wycieraczki są wyłączone");
         }


         char driverCategory = 'ś';
         char tick = '\u2713';
         out.println(driverCategory);
         out.println(tick);
         out.println((driverCategory));
         out.println(Character.isLetter(tick));
         int a = 10;
         int b = 20;
         int e;
         if(Short.MAX_VALUE > a + b){
             e = (short) (a + b);
         }
         byte f = 127;
         byte g = 127;
         byte h = (byte) (f + g);
         System.out.println(h);


     }


}
