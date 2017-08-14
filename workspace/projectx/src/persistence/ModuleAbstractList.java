package persistence;

import java.util.*;

public class ModuleAbstractList  extends ModuleAbstractSearchList{

	protected ModuleAbstractList() {
		super();
	}
	public Iterator<ModuleAbstract4Public> iterator(PersistentListProxi<ModuleAbstract4Public> listProxi) {
		return new PersistentListIterator<ModuleAbstract4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ModuleAbstract4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ModuleAbstractList copy() {
		ModuleAbstractList result = new ModuleAbstractList();
		result.data = (Vector<ModuleAbstract4Public>)this.data.clone();
		return result;
	}


}


