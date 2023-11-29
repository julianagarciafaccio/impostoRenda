package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.function.DoubleToLongFunction;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of taxpayers");
        int N = sc.nextInt();

        List<TaxPayer> list = new ArrayList<TaxPayer>();

        for (int i=0;i<N;i++){
            System.out.println("number #" + (1+i));
            System.out.println("individual or company(i/c)");
            char ch = sc.next().charAt(0);
            System.out.println("NAME");
            String name = sc.next(); // so aceita 1 palavra sem espaço
            System.out.println("ANUAL INCOME");
            Double anualIncome = sc.nextDouble();
            if (ch == 'i'){
                System.out.println("HEALTH EXPENDITURES");
                Double healthExpenditures = sc.nextDouble();
                Individual idv = new Individual(name , anualIncome ,healthExpenditures);
                list.add(idv);
            }
            else {
                System.out.println("NUMBER OF EMPLOYEES");
                Integer numberOfEmployees = sc.nextInt();
                list.add(new Company(name , anualIncome , numberOfEmployees));
            }
        }
        System.out.println();
        System.out.println("TEXT PAID");
        for (TaxPayer tp : list){
            System.out.println(tp.getName() + ": $" + String.format("%.2f " , tp.tax()));
        }
        double sum = 0.0;
        for (TaxPayer tp:list) {
            sum += tp.tax();
        }
        System.out.println("TOTAL TAXES " + String.format("%.2f", sum));



        sc.close();
    }
}
