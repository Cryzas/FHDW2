package persistence;

public class StudentSearchList extends DefaultSearchListRoot<Student4Public> implements Iterable<Student4Public> {

	public StudentSearchList(SearchListRoot<Student4Public> list){
		super(list);
	}
	public StudentSearchList(){
		super();
	}
	
	public void add (Student4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(StudentSearchList list) throws PersistenceException{
		java.util.Iterator<Student4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Student4Public> iterator() {
		return this.getData().iterator();
	}
  	public StudentSearchList copy() throws PersistenceException {
  		StudentSearchList result = new StudentSearchList();
  		result.add(this);
  		return result;
  	}
}


