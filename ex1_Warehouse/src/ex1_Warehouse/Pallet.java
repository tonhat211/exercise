package ex1_Warehouse;

public class Pallet {
	private String id;
	private int layersNum;
	private int height;
	public Pallet(String id, int layersNum, int height) {
		super();
		this.id = id;
		this.layersNum = layersNum;
		this.height = height;
	}
	public Pallet() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLayersNum() {
		return layersNum;
	}
	public void setLayersNum(int layersNum) {
		this.layersNum = layersNum;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		return "id: " + this.id + " || layer: " + this.layersNum + " || height: " + this.height;
	}
	
	public int getALayerHeight() {
		return this.height / this.layersNum;
	}
	
	public void increaseLayersNum() {
		this.layersNum++;
	}
	
//	public void updatePallet(int height) {
//		this.increaseLayer();
//		this.height = height;
//	}
	
	public static void main(String[] args) {
		Pallet p1 = new Pallet("tu1", 3, 600);
		Pallet p2 = new Pallet("tu2", 2, 1000);
		Pallet p3 = new Pallet("tu3", 1, 700);
		Pallet p4 = new Pallet("tu4", 5, 750);
		
		System.out.println(p1);
		System.out.println(p3.getALayerHeight());
		
//		p1.updatePallet(400);
		System.out.println(p1);
	}

}
