import java.util.ArrayList;
import java.util.Scanner;

public class View {
    // класс взаимодействия с пользователем
    static Scanner inp = new Scanner(System.in);

    public static int authorization() {
        // авторизация
        System.out.println("Здраствуйте! Пожалуйста авторезуйтесь");
        System.out.println("Кто вы?");
        System.out.println("1: Админ    2: Клиент    3: Выйти");
        int result = View.userInput();
        return result;
    }

    public static void printMenuAdmin() {
        // меню админа
        System.out.println("Меню:\n1: Список товаров\n 2: Добавить игрушку\n 3: Выйти");
    }

    public static void printMenuClient() {
        // меню пользователя
        System.out.println("Меню:\n1: Участвуй в розыгрыше\n 2: Воспользоватся купоном\n 3: Выйти");
    }

    public static int userInput() {
        // запрос ввода от пользователя
        System.out.println("Введите номер операции");
        int answer = 0;
        try{
            answer = inp.nextInt();
        }catch (Exception e) {
            System.out.println();
        }
            return answer;
    }

    public static void printPriseList(ArrayList<Toy> priceList) {
        // ввывод содержимого склада
        if (priceList.size() == 0){
            System.out.println("склад пуст");
        }
        for (int i = 0; i < priceList.size(); i++) {
            Toy toy = priceList.get(i);
            System.out.printf("%d, %s\n", toy.getNumberID(),toy.getName());
        }
        
    }

    public static void addToy() {
        // что добавить в список розыгрыша
        System.out.println("Какую игрушку вы хотите добавить?");
        System.out.println("1: Кукла\n2: Конструктор\n3: Робот");
    }

    public static boolean win(Toy toy) {
        // розыгрыш
        System.out.printf("Вы выиграли купон на %s, купите что-нибуть в нашем магазине на 500р и получите его бесплатно\n", toy.getName());
        System.out.println("Сохранить купон?");
        System.out.println("1: Да  2: Нет");
        int answer = View.userInput();
        if (answer == 1){
            return true;
        }
        return false;
    }

    public static boolean waste(ArrayList<Toy> queue) {
        // забираем подарки
        if (queue.size() == 0){
            System.out.println("У вас нет купонов");
            return false;
        }
        System.out.println("Вы готовы использовать купоны?");
        System.out.println("1: Да  2: Нет");
        int answer = View.userInput();
        if (answer == 1) {
            return true;
        }
        return false;
    }

    public static void incorrect() {
        // ошибка ввода
        System.out.println("неверный ввод");
    }

    
    
    
}
