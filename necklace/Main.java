package necklace;
public class Main {
    public static void main(String[] args) {
        // Создаём камни
        Stone diamond = new PreciousStone("Алмаз", 1.5, 5000, 0.95);
        Stone ruby    = new PreciousStone("Рубин", 0.8, 7000, 0.85);
        Stone sapphire = new PreciousStone("Сапфир", 1.2, 4500, 0.9);
        Stone amethyst  = new SemiPreciousStone("Аметист", 2.0, 300, 0.7);
        Stone turquoise = new SemiPreciousStone("Бирюза", 1.8, 200, 0.4);
        Stone garnet    = new SemiPreciousStone("Гранат", 1.1, 150, 0.6);

        // Ожерелье
        Necklace necklace = new Necklace();
        necklace.addStone(diamond);
        necklace.addStone(ruby);
        necklace.addStone(amethyst);
        necklace.addStone(garnet);

        // Вывод информации
        System.out.println("=== ОЖЕРЕЛЬЕ ===");
        necklace.show();
        System.out.println("Общий вес: " + necklace.totalWeight() + " карат");
        System.out.println("Общая стоимость: " + necklace.totalCost() + " $\n");

        // Сортировка
        necklace.sortByValue();
        System.out.println("=== ПОСЛЕ СОРТИРОВКИ ===");
        necklace.show();

        // Поиск по прозрачности
        System.out.println("\n=== КАМНИ С ПРОЗРАЧНОСТЬЮ 0.5-0.9 ===");
        necklace.findByTransparency(0.5, 0.9);
    }
}
