package necklace;

public class Stone {
    private String name;
    private double weight;          // в каратах
    private double pricePerCarat;   // цена за карат
    private double transparency;    // прозрачность (0.0 – 1.0)

    public Stone(String name, double weight, double pricePerCarat, double transparency) {
        this.name = name;
        this.weight = weight;
        this.pricePerCarat = pricePerCarat;
        this.transparency = transparency;
    }

    // --- Геттеры ---
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerCarat() {
        return pricePerCarat;
    }

    public double getTransparency() {
        return transparency;
    }

    // Стоимость камня
    public double cost() {
        return weight * pricePerCarat;
    }

    @Override
    public String toString() {
        return name + " (вес: " + weight + " карат, цена/карат: " + pricePerCarat +
                " $, прозрачность: " + transparency + ", стоимость: " + cost() + " $)";
    }
}