package persistence;

public class StudyGroupSearchList extends DefaultSearchListRoot<StudyGroup4Public> implements Iterable<StudyGroup4Public> {

	public StudyGroupSearchList(SearchListRoot<StudyGroup4Public> list){
		super(list);
	}
	public StudyGroupSearchList(){
		super();
	}
	
	public void add (StudyGroup4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(StudyGroupSearchList list) throws PersistenceException{
		java.util.Iterator<StudyGroup4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<StudyGroup4Public> iterator() {
		return this.getData().iterator();
	}
  	public StudyGroupSearchList copy() throws PersistenceException {
  		StudyGroupSearchList result = new StudyGroupSearchList();
  		result.add(this);
  		return result;
  	}
}


