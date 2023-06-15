import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SaveLoad {

    static String path = "file.txt";
    
    public static void load(Warehouse warehouse){
        BufferedReader br = null;
        try{
            File file = new File(path);
            if (!file.exists()){
                file.createNewFile();
            }

            br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null){
                String [] arayLine =  line.split(";");
                int id;
                double fl;
                Toy toy;
                id = Integer.parseInt(arayLine[0]);
                fl = Double.parseDouble(arayLine[2]);
                toy = new Toy(arayLine[1], fl, id);
                warehouse.addToy(toy);
            }
        
        }catch(IOException e){
            System.out.println("ошибка создания файла" + e);            
        }finally {
            try{
                br.close();
            } catch (IOException e) {
                System.out.println("error" + e);
            }
            
        }
    }

    public static void save(Warehouse warehouse){
        try{
            File file = new File(path);
            if (!file.exists()){
                file.createNewFile();
            }
            ArrayList<Toy> priceList = warehouse.getPriceList();
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < priceList.size(); i++) {
                String line = "" + priceList.get(i).getNumberID() + ";"+ priceList.get(i).getName() + ";"+ priceList.get(i).getFrequencyLoss() + ";";
                pw.println(line);
            }pw.close();
            
        
        }catch(IOException e){
            System.out.println("ошибка создания файла" + e);            
        }
    }
}
