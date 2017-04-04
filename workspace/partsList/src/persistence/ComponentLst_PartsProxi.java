package persistence;

import model.*;

import java.util.Iterator;
import java.util.Vector;

public class ComponentLst_PartsProxi extends PersistentListProxi<QuantifiedComponent4Public> {

  	private QuantifiedComponentList list;
  	private ComponentLst owner;

  	public ComponentLst_PartsProxi(ComponentLst owner) {
    	this.owner = owner;
  	}
  	public QuantifiedComponentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new QuantifiedComponentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theComponentLstFacade.partsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
	protected Vector<QuantifiedComponent4Public> getData() {
		return this.list.data;
	}
 
  	public Iterator<QuantifiedComponent4Public> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(QuantifiedComponent4Public entry) throws PersistenceException {
    	if (entry != null) {
      		QuantifiedComponentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
        	               	.partsAdd(owner.getId(), entry);
      		}
      		list.add((QuantifiedComponent4Public)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theComponentLstFacade.partsRem(entry.getListEntryId());
    	}
    	
  	}
  	public ComponentLst_PartsProxi copy(ComponentLst owner) throws PersistenceException {
  		ComponentLst_PartsProxi result = new ComponentLst_PartsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<QuantifiedComponent4Public> entries = (this.list == null ? new java.util.Vector<QuantifiedComponent4Public>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			QuantifiedComponent4Public current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
            	           .partsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
