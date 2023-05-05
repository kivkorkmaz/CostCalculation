package CostCalculation.Model;

public class CostCalculate {
	private int costNo;
	private String name;
	private int cost;
	   public CostCalculate(int costno, String name, int cost) {
	        this.costNo = costno;
	        this.name = name;
	        this.cost = cost;
	    }
	
	
	public int getcostNo() {
		return costNo;
	}
	public void setcostNo(int costNo) {
		this.costNo = costNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
