package persistence;

public class ProgramSearchList extends DefaultSearchListRoot<Program4Public> implements Iterable<Program4Public> {

	public ProgramSearchList(SearchListRoot<Program4Public> list){
		super(list);
	}
	public ProgramSearchList(){
		super();
	}
	
	public void add (Program4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ProgramSearchList list) throws PersistenceException{
		java.util.Iterator<Program4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Program4Public> iterator() {
		return this.getData().iterator();
	}
  	public ProgramSearchList copy() throws PersistenceException {
  		ProgramSearchList result = new ProgramSearchList();
  		result.add(this);
  		return result;
  	}
}


