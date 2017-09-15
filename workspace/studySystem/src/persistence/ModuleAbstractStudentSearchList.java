package persistence;

public class ModuleAbstractStudentSearchList extends DefaultSearchListRoot<ModuleAbstractStudent4Public> implements Iterable<ModuleAbstractStudent4Public> {

	public ModuleAbstractStudentSearchList(SearchListRoot<ModuleAbstractStudent4Public> list){
		super(list);
	}
	public ModuleAbstractStudentSearchList(){
		super();
	}
	
	public void add (ModuleAbstractStudent4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ModuleAbstractStudentSearchList list) throws PersistenceException{
		java.util.Iterator<ModuleAbstractStudent4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ModuleAbstractStudent4Public> iterator() {
		return this.getData().iterator();
	}
  	public ModuleAbstractStudentSearchList copy() throws PersistenceException {
  		ModuleAbstractStudentSearchList result = new ModuleAbstractStudentSearchList();
  		result.add(this);
  		return result;
  	}
}


