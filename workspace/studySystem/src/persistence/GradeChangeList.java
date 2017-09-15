package persistence;

import java.util.*;

public class GradeChangeList {

	protected Vector<GradeChange4Public> data; //List of proxies
	protected GradeChangeList() {
		this.data = new Vector<GradeChange4Public>();
	}
	public Iterator<GradeChange4Public> iterator(PersistentListProxi<GradeChange4Public> listProxi) {
		return new PersistentListIterator<GradeChange4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (GradeChange4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public GradeChangeList copy() {
		GradeChangeList result = new GradeChangeList();
		result.data = (Vector<GradeChange4Public>)this.data.clone();
		return result;
	}


}


