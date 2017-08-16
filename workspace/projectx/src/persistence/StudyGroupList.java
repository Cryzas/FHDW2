package persistence;

import java.util.*;

public class StudyGroupList  extends StudyGroupSearchList{

	protected StudyGroupList() {
		super();
	}
	public Iterator<StudyGroup4Public> iterator(PersistentListProxi<StudyGroup4Public> listProxi) {
		return new PersistentListIterator<StudyGroup4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (StudyGroup4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public StudyGroupList copy() {
		StudyGroupList result = new StudyGroupList();
		result.data = (Vector<StudyGroup4Public>)this.data.clone();
		return result;
	}


}


