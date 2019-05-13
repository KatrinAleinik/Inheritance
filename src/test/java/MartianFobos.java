public class MartianFobos extends Martian {
    private int heads;
    private int eyes = 120;
    private String name;


    public MartianFobos (String name){
        this.name = name;
    }

    public int getHeads(){
        return heads;
    }

    public void setHeads(int heads){
        this.heads = heads;
    }

    public void see(){
        System.out.println("Я вижу все!");
    }
}
