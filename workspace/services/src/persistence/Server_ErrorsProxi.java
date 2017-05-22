package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Server_ErrorsProxi extends PersistentListProxi<ErrorDisplay4Public> {

  	private ErrorDisplayList list;

  	public Server_ErrorsProxi(Server owner) {
  	}
  	public ErrorDisplayList getList() throws PersistenceException{
    	if (this.list == null) {
      		this.list = new ErrorDisplayList();
    	}
    	return this.list;
  	}
  	protected Vector<ErrorDisplay4Public> getData(){
  		return this.list.data;
  	}
  	public Iterator<ErrorDisplay4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
		return this.getList().getLength();
  	}
  	public void add(ErrorDisplay4Public entry) throws PersistenceException {
    	if (entry != null) {
      		ErrorDisplayList list = this.getList();
      		list.add((ErrorDisplay4Public)PersistentProxi.createListEntryProxi(entry.getId(),
                               			entry.getClassId(),
                               			-1));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
  	}
  	public Server_ErrorsProxi copy(Server owner) throws PersistenceException {
  		Server_ErrorsProxi result = new Server_ErrorsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	} 
  	public void store(){}
  
}
