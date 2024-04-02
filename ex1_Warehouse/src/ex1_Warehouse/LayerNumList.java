package ex1_Warehouse;

import java.util.ArrayList;

public class LayerNumList {
	private ArrayList<LayerNum> list = new ArrayList<>();

	public LayerNumList(ArrayList<LayerNum> list) {
		super();
		this.list = list;
	}

	public LayerNumList() {
		super();
	}

	public ArrayList<LayerNum> getList() {
		return list;
	}

	public void setList(ArrayList<LayerNum> list) {
		this.list = list;
	}
	
	public void add(LayerNum layer) {
		this.list.add(layer);
	}
	
	public boolean contains(LayerNum layer) {
		for(LayerNum lay : this.list) {
			if(lay.equals(layer))
				return true;
		}
		return false;

	}
	
	public String toString() {
		String re= "{\n";
		for(LayerNum layer : this.list) {
			re+= "\t" + layer +"\n";
		}
		re+="}";
		return re;
	}
	
	public void updateListByIndex(int index) {
		this.list.get(index).decreaseNum();
		if(this.list.get(index).getNum()==0) this.list.remove(index);
	}
	
	public void updateListByLayerHeight(int height) {
		LayerNum layer = new LayerNum(height, 1);
		int index = this.getIndex(layer);
		this.updateListByIndex(index);
	}
	
	public void updateNum(int index, int addNum) {
		this.list.get(index).updateNum(addNum);
	}
	
	public int getIndex(LayerNum layer) {
		for(int i=0;i<this.list.size();i++) {
			if(this.list.get(i).equals(layer)) return i;
		}
		return -1;
		
	}
	
	public int getHighestLayerIndex() {
		int max = this.list.get(0).getLayerHeight();
		int index=0;
		for(int i=1; i<this.list.size();i++) {
			if(this.list.get(i).getLayerHeight()> max) {
				max = this.list.get(i).getLayerHeight();
				index = i;
			}
			
		}
		
		return index;
	}
	
	public LayerNumList getTempList(int need) {
		LayerNumList re = new LayerNumList();
		for(LayerNum layer : this.list) {
			if(layer.getLayerHeight() <= need )
				re.add(layer);
		}
		
		return re;
	}
	
	public int getLayerHeightOf(int index) {
		return this.list.get(index).getLayerHeight();
	}
	
	public static void main(String[] args) {
		LayerNum l1 = new LayerNum(200, 4);
		LayerNum l2 = new LayerNum(500, 2);
		LayerNum l3 = new LayerNum(700, 1);
		LayerNum l4 = new LayerNum(150, 5);
		
		
		LayerNum l5 = new LayerNum(150, 6);
		
		
		
		LayerNumList li = new LayerNumList();
		li.add(l1);
		li.add(l2);
		li.add(l3);
		li.add(l4);
		
//		System.out.println(li.getIndex(l5));
//
//		
//		System.out.println(li);
//		
//		li.updateList(2);
//		li.updateList(1);
//		System.out.println(li);
//		
//		System.out.println(li.contains(l3));
//		
//		System.out.println(li.getIndex(l5));
		
		System.out.println(li.getHighestLayerIndex());
		System.out.println(li.getTempList(100).getList().size()==0);
		
	}
	
}
