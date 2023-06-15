import java.util.ArrayList;

public class Warehouse {
    // класс работы со складом
    private ArrayList<Toy> priceList;

    public Warehouse(){
        this.priceList = new ArrayList<Toy>();
    }

    public void addToy(Toy toy){
        this.priceList.add(toy);
    }

    public void delToy(Toy toy){
        this.priceList.remove(toy);
    }

    public ArrayList<Toy> getPriceList() {
        return priceList;
    }

    public Toy random(){
        // выбор рандомной игрушки с опорой на ее вес
        int size = priceList.size();
        double bigSize = 0;
        int index = 0;
        for (int i = 0; i < size; i++) {
            bigSize += priceList.get(i).getFrequencyLoss() * size;
        }
        double result = Math.random()*(bigSize+1);
        bigSize = 0;
        for (int i = 0; i < size; i++) {
            bigSize += priceList.get(i).getFrequencyLoss() * size;
            if (bigSize >= result){
                index = i;
                break;
            }
        }
        Toy toy = this.priceList.get(index);
        return toy;
    }
}
