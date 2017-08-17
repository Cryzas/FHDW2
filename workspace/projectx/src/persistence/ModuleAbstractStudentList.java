package persistence;

import java.util.*;

public class ModuleAbstractStudentList  extends ModuleAbstractStudentSearchList{

	protected ModuleAbstractStudentList() {
		super();
	}
	public Iterator<ModuleAbstractStudent4Public> iterator(PersistentListProxi<ModuleAbstractStudent4Public> listProxi) {
		return new PersistentListIterator<ModuleAbstractStudent4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ModuleAbstractStudent4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ModuleAbstractStudentList copy() {
		ModuleAbstractStudentList result = new ModuleAbstractStudentList();
		result.data = (Vector<ModuleAbstractStudent4Public>)this.data.clone();
		return result;
	}


}


