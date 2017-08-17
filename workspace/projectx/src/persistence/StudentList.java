package persistence;

import java.util.*;

public class StudentList  extends StudentSearchList{

	protected StudentList() {
		super();
	}
	public Iterator<Student4Public> iterator(PersistentListProxi<Student4Public> listProxi) {
		return new PersistentListIterator<Student4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Student4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public StudentList copy() {
		StudentList result = new StudentList();
		result.data = (Vector<Student4Public>)this.data.clone();
		return result;
	}


}


