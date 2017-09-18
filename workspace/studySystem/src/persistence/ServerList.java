package persistence;

import java.util.*;

public class ServerList  extends ServerSearchList{

	protected ServerList() {
		super();
	}
	public Iterator<Server4Public> iterator(PersistentListProxi<Server4Public> listProxi) {
		return new PersistentListIterator<Server4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Server4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ServerList copy() {
		ServerList result = new ServerList();
		result.data = (Vector<Server4Public>)this.data.clone();
		return result;
	}


}


