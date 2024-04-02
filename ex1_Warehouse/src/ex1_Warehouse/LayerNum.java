package ex1_Warehouse;

public class LayerNum {
	private int layerHeight;
	private int num;
	public LayerNum(int layer, int num) {
		super();
		this.layerHeight = layer;
		this.num = num;
	}
	public LayerNum() {
		super();
	}
	public int getLayerHeight() {
		return layerHeight;
	}
	public void setLayerHeight(int layerHeight) {
		this.layerHeight = layerHeight;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void updateNum(int num) {
		this.num+=num;
	}
	
	public void decreaseNum() {
		this.num--;
	}
	
	public boolean equals(LayerNum layer) {
		if(this.layerHeight == layer.getLayerHeight()) {
			return true;
		} 
		return false;
	}
	
	public String toString() {
		return "(" + this.layerHeight + " : " + this.num +")";
	}
	
	public static void main(String[] args) {
		LayerNum l1 = new LayerNum(200, 4);
		LayerNum l2 = new LayerNum(500, 2);
		LayerNum l3 = new LayerNum(700, 1);
		LayerNum l4 = new LayerNum(150, 5);
		
		LayerNum l5 = new LayerNum(150, 7);
		
		System.out.println(l1);
		l1.decreaseNum();
		System.out.println(l1);
		System.out.println(l4.equals(l1));
		
		
		l2.updateNum(1);
		System.out.println(l2);
	}
}
