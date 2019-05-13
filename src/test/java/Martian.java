public class Martian implements Alien  {
    private int eyes;
    private int legs;
    private int arms;
    private String name;
    public Martian(){

    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Martian(String name){
        this.name = name;

    }
    public void setEyes(int eyes){
        this.eyes = eyes;
    }

    public int getEyes(){
        return eyes;
    }
    public void setLegs(int legs){
        this.legs = legs;
    }

    public int getLegs(){
        return legs;
    }

    public void setArms(int arms){
        this.arms = arms;
    }
    public int getArms(){
        return arms;
    }

    public void see(){
        if (this.eyes>0){
            System.out.println("Я все вижу");
        }
        else System.out.println("Ты издеваешься?");
    }
    public void speaks (){
        System.out.println("Мы пришли с миром!");

    }
    public void chases (int speed){
        if (speed >=20){
            System.out.println("Я тебя догоню и съем!");
        }
        else System.out.println("Стой! Давай поговорим!");
    }
    public void scares(){
        System.out.println("Pppppppppppppppp");
    }
}
