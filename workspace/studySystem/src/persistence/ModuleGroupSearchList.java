package persistence;

public class ModuleGroupSearchList extends DefaultSearchListRoot<ModuleGroup4Public> implements Iterable<ModuleGroup4Public> {

	public ModuleGroupSearchList(SearchListRoot<ModuleGroup4Public> list){
		super(list);
	}
	public ModuleGroupSearchList(){
		super();
	}
	
	public void add (ModuleGroup4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ModuleGroupSearchList list) throws PersistenceException{
		java.util.Iterator<ModuleGroup4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ModuleGroup4Public> iterator() {
		return this.getData().iterator();
	}
  	public ModuleGroupSearchList copy() throws PersistenceException {
  		ModuleGroupSearchList result = new ModuleGroupSearchList();
  		result.add(this);
  		return result;
  	}
}


