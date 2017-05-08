package persistence;

import java.util.Vector;

public class DefaultSearchListRoot<T extends AbstractPersistentRoot> extends SearchListRoot<T> {

	protected Vector<T> data;
	
	public DefaultSearchListRoot(){
		this.data = new Vector<T>();
	}
	protected DefaultSearchListRoot(SearchListRoot<T> list){
		this.data = list.getData();
	}
	
	protected Vector<T> getData(){
		return this.data;
	}
}