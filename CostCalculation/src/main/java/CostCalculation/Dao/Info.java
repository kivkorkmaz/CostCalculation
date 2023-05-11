package CostCalculation.Dao;

public class Info {
    private int costno;
    private String name;
    private int cost;

    public Info(int costno, String name, int cost) {
        this.costno = costno;
        this.name = name;
        this.cost = cost;
    }

    public int getCostno() {
        return costno;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
