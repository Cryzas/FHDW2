package persistence;

import java.util.*;

public class ProgramStudentList {

	protected Vector<ProgramStudent4Public> data; //List of proxies
	protected ProgramStudentList() {
		this.data = new Vector<ProgramStudent4Public>();
	}
	public Iterator<ProgramStudent4Public> iterator(PersistentListProxi<ProgramStudent4Public> listProxi) {
		return new PersistentListIterator<ProgramStudent4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ProgramStudent4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ProgramStudentList copy() {
		ProgramStudentList result = new ProgramStudentList();
		result.data = (Vector<ProgramStudent4Public>)this.data.clone();
		return result;
	}


}


