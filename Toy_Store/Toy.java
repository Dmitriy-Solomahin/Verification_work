public class Toy {
    // основной класс игрушек
    private static int id = 1;

    private String name;
    private int numberID;
    private double frequencyLoss;

    public Toy(String name, Double frequencyLoss, int id) {
        this.name = name;
        this.numberID = id;
        this.frequencyLoss = frequencyLoss;
    }

    public Toy(String name, Double frequencyLoss){
        this.name = name;
        this.numberID = id;
        this.frequencyLoss = frequencyLoss;
        id += 1;
    }
    public String getName() {
        return name;
    }

    public int getNumberID() {
        return numberID;
    }

    public double getFrequencyLoss() {
        return frequencyLoss;
    }

    public int getID(){
        return id;
    }

    public void setFrequencyLoss(double frequencyLoss) {
        this.frequencyLoss = frequencyLoss;
    }

    
}