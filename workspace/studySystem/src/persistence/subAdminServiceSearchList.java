package persistence;

public class subAdminServiceSearchList extends DefaultSearchListRoot<subAdminService4Public> implements Iterable<subAdminService4Public> {

	public subAdminServiceSearchList(SearchListRoot<subAdminService4Public> list){
		super(list);
	}
	public subAdminServiceSearchList(){
		super();
	}
	
	public void add (subAdminService4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(subAdminServiceSearchList list) throws PersistenceException{
		java.util.Iterator<subAdminService4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<subAdminService4Public> iterator() {
		return this.getData().iterator();
	}
  	public subAdminServiceSearchList copy() throws PersistenceException {
  		subAdminServiceSearchList result = new subAdminServiceSearchList();
  		result.add(this);
  		return result;
  	}
}


