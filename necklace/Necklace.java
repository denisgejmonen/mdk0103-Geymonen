package necklace;

import java.util.ArrayList;
import java.util.List;

public class Necklace {
    private List<Stone> stones = new ArrayList<>();

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    // Общий вес ожерелья
    public double totalWeight() {
        double sum = 0;
        for (Stone s : stones) {
            sum += s.getWeight();   // используем геттер
        }
        return sum;
    }

    // Общая стоимость ожерелья
    public double totalCost() {
        double sum = 0;
        for (Stone s : stones) {
            sum += s.cost();
        }
        return sum;
    }

    // Сортировка камней по убыванию стоимости
    public void sortByValue() {
        stones.sort((a, b) -> Double.compare(b.cost(), a.cost()));
    }

    // Вывод всех камней
    public void show() {
        for (Stone s : stones) {
            System.out.println(s);
        }
    }

    // Поиск камней по диапазону прозрачности
    public void findByTransparency(double min, double max) {
        boolean found = false;
        for (Stone s : stones) {
            double t = s.getTransparency();   // используем геттер
            if (t >= min && t <= max) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Таких камней нет.");
        }
    }
}