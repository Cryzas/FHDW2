package persistence;

import java.util.*;

public class ComponentList  extends ComponentSearchList{

	protected ComponentList() {
		super();
	}
	public Iterator<Component4Public> iterator(PersistentListProxi<Component4Public> listProxi) {
		return new PersistentListIterator<Component4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Component4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ComponentList copy() {
		ComponentList result = new ComponentList();
		result.data = (Vector<Component4Public>)this.data.clone();
		return result;
	}


}


