package net.skhu.dto;

public class Product {
	String name;
	int unitCost;


	public Product(String name, int unitCost) {
//		부모 클래스가 없으므로, super(); 호출은 불필요하다
		this.name = name;
		this.unitCost = unitCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
}
