package persistence;

public class ProgramSGroupSearchList extends DefaultSearchListRoot<ProgramSGroup4Public> implements Iterable<ProgramSGroup4Public> {

	public ProgramSGroupSearchList(SearchListRoot<ProgramSGroup4Public> list){
		super(list);
	}
	public ProgramSGroupSearchList(){
		super();
	}
	
	public void add (ProgramSGroup4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ProgramSGroupSearchList list) throws PersistenceException{
		java.util.Iterator<ProgramSGroup4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ProgramSGroup4Public> iterator() {
		return this.getData().iterator();
	}
  	public ProgramSGroupSearchList copy() throws PersistenceException {
  		ProgramSGroupSearchList result = new ProgramSGroupSearchList();
  		result.add(this);
  		return result;
  	}
}


