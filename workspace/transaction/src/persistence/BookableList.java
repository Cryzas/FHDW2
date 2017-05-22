package persistence;

import java.util.*;

public class BookableList {

	protected Vector<Bookable4Public> data; //List of proxies
	protected BookableList() {
		this.data = new Vector<Bookable4Public>();
	}
	public Iterator<Bookable4Public> iterator(PersistentListProxi<Bookable4Public> listProxi) {
		return new PersistentListIterator<Bookable4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Bookable4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public BookableList copy() {
		BookableList result = new BookableList();
		result.data = (Vector<Bookable4Public>)this.data.clone();
		return result;
	}


}


