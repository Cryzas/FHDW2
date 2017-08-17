package persistence;

public class ProgramStudentSearchList extends DefaultSearchListRoot<ProgramStudent4Public> implements Iterable<ProgramStudent4Public> {

	public ProgramStudentSearchList(SearchListRoot<ProgramStudent4Public> list){
		super(list);
	}
	public ProgramStudentSearchList(){
		super();
	}
	
	public void add (ProgramStudent4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ProgramStudentSearchList list) throws PersistenceException{
		java.util.Iterator<ProgramStudent4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ProgramStudent4Public> iterator() {
		return this.getData().iterator();
	}
  	public ProgramStudentSearchList copy() throws PersistenceException {
  		ProgramStudentSearchList result = new ProgramStudentSearchList();
  		result.add(this);
  		return result;
  	}
}


