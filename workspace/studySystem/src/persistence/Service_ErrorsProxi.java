package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class Service_ErrorsProxi extends PersistentListProxi<ErrorDisplay4Public> {

  	private ErrorDisplayList list;

  	public Service_ErrorsProxi(Service owner) {
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
  	public Service_ErrorsProxi copy(Service owner) throws PersistenceException {
  		Service_ErrorsProxi result = new Service_ErrorsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	} 
  	public void store(){}
  
}
