package persistence;

import java.util.*;

public class ProgramList  extends ProgramSearchList{

	protected ProgramList() {
		super();
	}
	public Iterator<Program4Public> iterator(PersistentListProxi<Program4Public> listProxi) {
		return new PersistentListIterator<Program4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Program4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ProgramList copy() {
		ProgramList result = new ProgramList();
		result.data = (Vector<Program4Public>)this.data.clone();
		return result;
	}


}


