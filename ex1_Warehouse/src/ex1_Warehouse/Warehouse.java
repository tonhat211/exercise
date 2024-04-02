package ex1_Warehouse;

import java.util.ArrayList;

public class Warehouse {
	private ArrayList<Pallet> pallets = new ArrayList<>();

	public Warehouse(ArrayList<Pallet> pallets) {
		super();
		this.pallets = pallets;
	}

	public Warehouse() {
		super();
	}

	public ArrayList<Pallet> getPallets() {
		return pallets;
	}

	public void setPallets(ArrayList<Pallet> pallets) {
		this.pallets = pallets;
	}
	
	public void add(Pallet p) {
		this.pallets.add(p);
	}
	
	public String toString() {
		String re= "{\n";
		for(Pallet p : this.pallets) {
			re+= "\t" + p +"\n";
		}
		re+="}";
		return re;
	}
	
	public LayerNumList createLayerNumList() {	
		LayerNumList li = new LayerNumList();
		for(Pallet p : this.pallets) {
			int layerHeight = p.getALayerHeight();
			int num = p.getLayersNum();
			LayerNum layer = new LayerNum(layerHeight, num);
			if(li.contains(layer)) {
				int index = li.getIndex(layer);
				li.updateNum(index, layer.getNum());
			} else {
				li.add(layer);
			}	
		}
		
		return li;
	}
	
	public static void printPallets(ArrayList<Pallet> ps) {
		String  re  ="";
		for(Pallet p : ps) {
			re+=p  +"\n";
		}
		System.out.println(re);
	}
	
//	public ArrayList<Pallet> arragePallets() {
	public int arragePallets() {
		ArrayList<Pallet> re = new ArrayList<>();
		LayerNumList li = this.createLayerNumList();
		
		
//		System.out.println("li:" +li);
		
		
		boolean isFinish = false;
		int id=1;
		
		System.out.println("Bat dau");
//		int bigloop = 0;
		while(isFinish!=true) {
			String pId = "o_TU" + id++;
//			System.out.println("big loop " + ++bigloop);
//			System.out.println("isFinish: " +  isFinish);

			int numOfLayers = 1;
			int need = 1200;
//			System.out.println("so layer: " + numOfLayers);
//			System.out.println("need: " + need);
	

			int maxIndex = li.getHighestLayerIndex();
			
//			System.out.println("max index now: " + maxIndex);
			
			int highestLayer  = li.getLayerHeightOf(maxIndex);
			need-=highestLayer;
			li.updateListByIndex(maxIndex);
			
			System.out.println("xep layer cao " + highestLayer + " vao pallet " + pId);
			
//			System.out.println("need: " + need);
			
//			int smallLoop = 0;
			
			while(need > 0) {
//				System.out.println("small loop " + ++smallLoop);
//				System.out.println("isFinish: " +  isFinish);

				
				LayerNumList tempList = li.getTempList(need);
				if(tempList.getList().size()==0) break;
				int maxIndexTemp = tempList.getHighestLayerIndex();
				int maxHighestLayerTemp = tempList.getLayerHeightOf(maxIndexTemp);
				need-=maxHighestLayerTemp;
				li.updateListByLayerHeight(maxHighestLayerTemp);
				numOfLayers++;
				System.out.println("xep them layer cao " + maxHighestLayerTemp + " vao pallet " + pId);

				
//				System.out.println("so layer: " + numOfLayers);
//				System.out.println("need: " + need);
				
			}
			

			
			Pallet p = new Pallet(pId, numOfLayers, 1200-need);
			System.out.println("Da hoan thanh pallet " + p);
			System.out.println("----------------------------");
			
//			System.out.println(p);
			
			re.add(p);
			
			if(li.getList().size()==0) isFinish = true;
			
//			System.out.println("isFinish: " +  isFinish);


			
			
			
			
		}
		System.out.println("da hoan thanh");
		
		
		return re.size();
	}
	
	public static void main(String[] args) {
		Pallet p1 = new Pallet("tu1", 3, 600);
		Pallet p2 = new Pallet("tu2", 2, 1000);
		Pallet p3 = new Pallet("tu3", 1, 700);
		Pallet p4 = new Pallet("tu4", 5, 750);
		
		Pallet p5 = new Pallet("tu5", 2, 200);
//		Pallet p6 = new Pallet("tu6", 1, 1200);
		
		
		
		Warehouse house = new Warehouse();
		house.add(p1);
		house.add(p2);
		house.add(p3);
		house.add(p4);
		
		house.add(p5);
//		house.add(p6);
		
//		System.out.println(house);
		
//		LayerNumList layerList = house.createLayerNumList();
//		System.out.println(layerList);
		
//		System.out.println(house.arragePallets());
//		printPallets(house.arragePallets());
		System.out.println("so luong order pallet da dung: " + house.arragePallets());
		
		
		
		
		
	}
}
