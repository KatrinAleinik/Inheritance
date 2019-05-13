import org.testng.annotations.Test;

import java.util.Arrays;

public class Test1 {
    @Test
    public void testMethod1(){
        System.out.println("Hello, world!");

    }

    @Test
    public void testPrintEvenNumbers(){
        for (int i = 0; i<=10; i++){
            if (i%2==1) printValue(i);
        }
    }

    public void printValue(int valueToPrint){
        System.out.println(valueToPrint);
    }
    @Test
    public void NumbersOfLetters(String s){
        int result=0;
        String input = "Hello, World";

        for(char eachChar : input.toCharArray()){
            if (eachChar =='l') result++;
        }
        System.out.println(result);
    }

    @Test
    public void testReversTheString() {
        String s = "Dot saw I ";
        String reverse = "";
        for (int i = s.length ()- 1; i >=0; i-- ){
            reverse = s;
        }
    }


    @Test
    public void testAlienMartian(){
        Martian John = new Martian("John");
        John.setArms(2);
        John.setEyes(2);
        John.setLegs(2);
        John.speaks();
        John.chases(23);
        John.see();
        John.scares();
    }
    @Test
    public void testAlienMartianFobos(){
        Martian John = new Martian("John");
        John.setArms(3);
        John.setEyes(0);
        John.setLegs(2);
        John.speaks();
        John.chases(19);
        John.see();
        John.scares();
        MartianFobos Greg = new MartianFobos("Greg");
        Greg.setLegs(5);
        Greg.see();
        Greg.chases(25);
        Greg.speaks();
        Greg.setHeads(2);
        Greg.setArms(5);

    }
}


