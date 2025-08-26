package Romanos;

import java.util.Scanner;
public class Romanos
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int miles = num/1000;
        int centena = num%1000/100;
        int decena = num%100/10;
        int unidad = num%10;
        System.out.println("la conversion de " + num + " es:");
        if ((miles > 0)&& (miles < 4))
        {
            for (int i = 1; i <= miles; i++)
            {
                System.out.print("M");
            }
        }
        if (centena <= 3)
        {
            for (int i = 0; i < centena; i++)
            {
                System.out.print("C");
            }
        }else if (centena == 4)
        {
            System.out.print("CD");
        }
        else if (centena == 5)
        {
            System.out.print("D");
        }else if ((centena > 5) && (centena < 9))
        {
            System.out.print("D");
            for (int i = 5; i < centena; i++){
                System.out.print("C");
            }
        }
        else
        {
            System.out.print("CM");
        }
        if (decena <= 3)
        {
            for (int i = 0; i < decena; i++)
            {
                System.out.print("X");
            }
        }
        else if (decena == 4)
        {
            System.out.print("XL");
        }
        else if (decena == 5)
        {
            System.out.print("L");
        }
        else if ((decena > 5) && (decena < 9))
        {
            System.out.print("L");
            for (int i = 5; i < decena; i++)
            {
                System.out.print("X");
            }
        }
        else
        {
            System.out.print("XC");
        }
        if ( unidad < 4)
        {
            for (int i = 0; i < unidad; i++)
            {
                System.out.print("I");
            }
        }
        else if (unidad == 4)
        {
            System.out.print("IV");
        }
        else if (unidad == 5)
        {
            System.out.print("V");
        }
        else if ((unidad > 5) && (unidad < 9))
        {
            System.out.print("V");
            for (int i = 5; i < unidad; i++)
            {
                System.out.print("I");
            }
        }
        else
        {
            System.out.print("IX");
        }
    }
}
