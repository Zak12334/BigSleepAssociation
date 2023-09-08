import java.io.Serializable;
public class ObjectList implements Serializable {
	// list of objects
	private Object[] list;
	// number of objects in list
	private int total;

	// constructor
	public ObjectList(int size) {
		this.list = new Object[size];
		this.total = 0;
	}

	// adds an object to the list
	public boolean add(Object o) {
		if (this.isFull()) {
			return false;
		}
		this.list[this.total] = o;
		this.total++;
		return true;
	}

	public Object getObject(int index) {
		return list[index];
	}

	// checks if the list is empty
	public boolean isEmpty() {
		return this.total == 0;
	}

	// checks if the list is full
	public boolean isFull() {
		return this.total == this.list.length;
	}

	// gets the object at the specified index
	public Object getItem(int index) {
		return this.list[index];
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return this.total;
	}

	public Object[] getList() {
		return list;
	}

	public void setList(Object[] list) {
		this.list = list;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean remove(int index) {
		if (this.isEmpty()) {
			return false;
		}
		for (int i = index; i < this.total - 1; i++) {
			this.list[i] = this.list[i + 1];
		}
		this.list[this.total - 1] = null;
		this.total--;
		return true;

	}
}