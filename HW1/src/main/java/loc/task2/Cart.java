package loc.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing()
    {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        if(foodstuffs.stream().anyMatch(Food::getProteins)) proteins=true;
        if(foodstuffs.stream().anyMatch(Food::getFats)) fats=true;
        if(foodstuffs.stream().anyMatch(Food::getCarbohydrates)) carbohydrates=true;


        if (proteins && fats && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        foodstuffs.addAll((Collection<? extends T>) market.getThings(Food.class).stream()
                .filter(Food::getProteins)
                .limit(proteins?0:1).toList());

        foodstuffs.addAll((Collection<? extends T>) market.getThings(Food.class).stream()
                .filter(Food::getCarbohydrates)
                .limit(carbohydrates?0:1).toList());

        foodstuffs.addAll((Collection<? extends T>) market.getThings(Food.class).stream()
                .filter(Food::getFats)
                .limit(fats?0:1).toList());


        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }

}
