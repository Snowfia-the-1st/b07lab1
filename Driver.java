import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String [] args) {
        // Polynomial p = new Polynomial();
        // System.out.println(p.evaluate(3));
        // double [] c1 = {6,0,0,5};
        // Polynomial p1 = new Polynomial(c1);
        // double [] c2 = {0,-2,0,0,-9};
        // Polynomial p2 = new Polynomial(c2);
        // Polynomial s = p1.add(p2);
        double[] m1= {6,-2,9};
        int[] m1x= {0,1,2};
        Polynomial multiply1= new Polynomial(m1,m1x);
        double[] m2= {5,-2,9};
        int[] m2x= {0,2,3};
        Polynomial multiply2= new Polynomial(m2,m2x);
        double[] m3= {-1,-2,9};
        int[] m3x= {2,1,4};
        Polynomial multiply3= new Polynomial(m3,m3x);
        double[] m4= {1,5,9};
        int[] m4x= {5,2,3};
        Polynomial multiply4= new Polynomial(m4,m4x);
        
        System.out.println("m1(0.1) = " + multiply1.evaluate(0.1));
        if(multiply1.hasRoot(1))
        System.out.println("1 is a root of m1");
        else
        System.out.println("1 is not a root of m1");
        Polynomial result = multiply2.multiply(multiply1);
        Polynomial result2 = multiply2.add(multiply1);
        Polynomial result3 = multiply3.multiply(multiply4);
        try {
    multiply2.saveToFile("file.txt");
} catch (IOException e) {
    e.printStackTrace();
}
        

        System.out.print("add test1: ");
        for (int i = 0; i < result2.coefficients.length; i++) {
            System.out.print("(" + result2.coefficients[i] + ", " + result2.x[i] + ") ");
        }
        System.out.println();
        System.out.print("multiply test2: ");
        for (int i = 0; i < result3.coefficients.length; i++) {
            System.out.print("(" + result3.coefficients[i] + ", " + result3.x[i] + ") ");
        }
        System.out.println();
        try {
            File file = new File("file.txt");
            Polynomial p = new Polynomial(file);

    for (int i = 0; i < p.coefficients.length; i++) {
        System.out.print("(" + p.coefficients[i] + ", " + p.x[i] + ") ");
    }
    System.out.println("savetofile and polynomial test1");
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
    multiply4.saveToFile("file.txt");
    } catch (IOException e) {
        e.printStackTrace();
        }
    try {
            File file = new File("file.txt");
            Polynomial p = new Polynomial(file);

    for (int i = 0; i < p.coefficients.length; i++) {
        System.out.print("(" + p.coefficients[i] + ", " + p.x[i] + ") ");
    }
    System.out.println("savetofile and polynomial test2");
    } catch (IOException e) {
        e.printStackTrace();
    }

System.out.print("multiply test: ");
for (int i = 0; i < result.coefficients.length; i++) {
    System.out.print("(" + result.coefficients[i] + ", " + result.x[i] + ") ");
}
System.out.println();


        }
    }