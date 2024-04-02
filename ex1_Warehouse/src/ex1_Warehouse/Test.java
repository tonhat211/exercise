package ex1_Warehouse;

public class Test {
	public static void main(String[] args) {
		Pallet p1 = new Pallet("tu1", 3, 600);
		Pallet p2 = new Pallet("tu2", 2, 1000);
		Pallet p3 = new Pallet("tu3", 1, 700);
		Pallet p4 = new Pallet("tu4", 5, 750);
			
		Warehouse house = new Warehouse();
		house.add(p1);
		house.add(p2);
		house.add(p3);
		house.add(p4);
		
		System.out.println("so luong order pallet da dung: " + house.arragePallets());
		
		
		
		
		
	}
}
