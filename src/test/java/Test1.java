import org.testng.annotations.Test;

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
        Martian john = new Martian();
        john.setArms(2);
        john.setEyes(2);
        john.setLegs(2);
        john.speaks();
        john.chases(23);
        john.see();
        john.scares();
    }
    @Test
    public void testAlienMartianFobos(){
        Martian john = new Martian();
        john.setArms(3);
        john.setEyes(0);
        john.setLegs(2);
        john.speaks();
        john.chases(19);
        john.see();
        john.scares();
        MartianFobos greg = new MartianFobos("Greg");
        greg.setLegs(5);
        greg.see();
        greg.chases(25);
        greg.speaks();
        greg.setHeads(2);
        greg.setArms(5);
        greg.setEyes(3);
        greg.setLegs(5);


    }
}


