package persistence;

import java.util.*;

public class ErrorDisplayList {

	protected Vector<ErrorDisplay4Public> data; //List of proxies
	protected ErrorDisplayList() {
		this.data = new Vector<ErrorDisplay4Public>();
	}
	public Iterator<ErrorDisplay4Public> iterator(PersistentListProxi<ErrorDisplay4Public> listProxi) {
		return new PersistentListIterator<ErrorDisplay4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ErrorDisplay4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ErrorDisplayList copy() {
		ErrorDisplayList result = new ErrorDisplayList();
		result.data = (Vector<ErrorDisplay4Public>)this.data.clone();
		return result;
	}


}


