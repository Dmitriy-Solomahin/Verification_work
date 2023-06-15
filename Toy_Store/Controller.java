import java.util.ArrayList;

public class Controller {
    // класс контроллера
    public static void start(){
        Warehouse warehouse = new Warehouse();
        SaveLoad.load(warehouse);
        while (true) {
            int num = View.authorization();
            if (num == 1){
                boolean flag = true;
                while (flag){
                    View.printMenuAdmin();
                    num = View.userInput();
                    switch (num){
                        case 1:
                            View.printPriseList(warehouse.getPriceList());
                            break;
                        case 2:
                            View.addToy();
                            int numberToy = View.userInput();
                            Toy toy = null;
                            if (numberToy == 1){
                                toy = new Doll();
                            }
                            else if (numberToy == 2) {
                                toy = new Meccano();
                            }
                            else if (numberToy == 3) {
                                toy = new Robot();
                            }
                            warehouse.addToy(toy);
                            break;
                        case 3:
                            flag = false;
                            break;
                    }
                }
            }
            else if (num == 2){
                boolean flag = true;
                ArrayList<Toy> queue = new ArrayList<Toy>();
                while (flag) {
                    View.printMenuClient();
                    num = View.userInput();
                    switch (num){
                        case 1:
                            Toy result = warehouse.random();
                            boolean answer = View.win(result);
                            if (answer == true){
                                queue.add(result);
                            }
                            break;
                        case 2:
                            if (View.waste(queue) == true){
                                for (int i = 0; i < queue.size(); i++) {
                                    warehouse.delToy(queue.get(i));
                                }
                                queue.clear();
                            }
                            break;
                        case 3:
                            flag = false;
                            break;
                    }
                }
            }
            else if (num == 3){
                SaveLoad.save(warehouse);
                break;
            }
            else{
                View.incorrect();
            }
        }
    }
}
