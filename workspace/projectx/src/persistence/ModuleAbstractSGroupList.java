package persistence;

import java.util.*;

public class ModuleAbstractSGroupList {

	protected Vector<ModuleAbstractSGroup4Public> data; //List of proxies
	protected ModuleAbstractSGroupList() {
		this.data = new Vector<ModuleAbstractSGroup4Public>();
	}
	public Iterator<ModuleAbstractSGroup4Public> iterator(PersistentListProxi<ModuleAbstractSGroup4Public> listProxi) {
		return new PersistentListIterator<ModuleAbstractSGroup4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ModuleAbstractSGroup4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ModuleAbstractSGroupList copy() {
		ModuleAbstractSGroupList result = new ModuleAbstractSGroupList();
		result.data = (Vector<ModuleAbstractSGroup4Public>)this.data.clone();
		return result;
	}


}


