class main {
    public static void main(String[] args) {
        // Создаём камни
        Stone diamond = new PreciousStone("Алмаз", 1.5, 5000, 0.95);
        Stone ruby    = new PreciousStone("Рубин", 0.8, 7000, 0.85);
        Stone sapphire= new PreciousStone("Сапфир",1.2, 4500, 0.9);
        Stone amethyst   = new SemiPreciousStone("Аметист", 2.0, 300, 0.7);
        Stone turquoise  = new SemiPreciousStone("Бирюза", 1.8, 200, 0.4);
        Stone garnet     = new SemiPreciousStone("Гранат", 1.1, 150, 0.6);

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

// -------- КЛАССЫ КАМНЕЙ ---------
class Stone {
    public String name;
    public double weight;
    public double pricePerCarat;
    public double transparency;

    public Stone(String name, double weight, double pricePerCarat, double transparency) {
        this.name = name;
        this.weight = weight;
        this.pricePerCarat = pricePerCarat;
        this.transparency = transparency;
    }
    public double cost() { return weight * pricePerCarat; }
    public String toString() {
        return name + " (вес: " + weight + " карат, цена/карат: " + pricePerCarat +
                " $, прозрачность: " + transparency + ", стоимость: " + cost() + " $)";
    }
}
class PreciousStone extends Stone {
    public PreciousStone(String n, double w, double p, double t) { super(n,w,p,t); }
}
class SemiPreciousStone extends Stone {
    public SemiPreciousStone(String n, double w, double p, double t) { super(n,w,p,t); }
}

// -------- КЛАСС ОЖЕРЕЛЬЯ ---------
class Necklace {
    private java.util.ArrayList<Stone> stones = new java.util.ArrayList<>();
    public void addStone(Stone s) { stones.add(s); }
    public double totalWeight() { double sum=0; for(Stone s:stones) sum+=s.weight; return sum; }
    public double totalCost()   { double sum=0; for(Stone s:stones) sum+=s.cost();   return sum; }
    public void sortByValue()   { stones.sort((a,b)->Double.compare(b.cost(), a.cost())); }
    public void show()          { for(Stone s:stones) System.out.println(s); }
    public void findByTransparency(double min, double max) {
        boolean found = false;
        for(Stone s:stones) if(s.transparency>=min && s.transparency<=max) {
            System.out.println(s); found=true;
        }
        if(!found) System.out.println("Таких камней нет.");
    }
}