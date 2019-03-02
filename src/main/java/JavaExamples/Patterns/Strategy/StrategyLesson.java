package JavaExamples.Patterns.Strategy;


public class StrategyLesson {
    public static void main(String[] args) {
        double startPrice = 100;
        Strategy strategy_1 = new FullPrice();
        Strategy strategy_2 = new HalfPrice();

        ContextStrategy context_1 = new ContextStrategy(strategy_1);
        double price_1 = context_1.getPrice(startPrice);
        ContextStrategy context_2 = new ContextStrategy(strategy_2);
        double price_2 = context_2.getPrice(startPrice);
        System.out.println(price_1);
        System.out.println(price_2);
    }
}

interface Strategy {
    double getPrice(double price);
}

class FullPrice implements Strategy {
    @Override
    public double getPrice(double startPrice) {
        return startPrice;
    }
}

class HalfPrice implements Strategy {
    @Override
    public double getPrice(double startPrice) {
        return startPrice * 0.5;
    }
}

class ContextStrategy {
    Strategy strategy;

    public ContextStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public double getPrice(double price) {
        return strategy.getPrice(price);
    }

}