package persistence;

import java.util.*;

public class FolderList {

	protected Vector<Folder4Public> data; //List of proxies
	protected FolderList() {
		this.data = new Vector<Folder4Public>();
	}
	public Iterator<Folder4Public> iterator(PersistentListProxi<Folder4Public> listProxi) {
		return new PersistentListIterator<Folder4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Folder4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public FolderList copy() {
		FolderList result = new FolderList();
		result.data = (Vector<Folder4Public>)this.data.clone();
		return result;
	}


}


