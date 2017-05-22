package persistence;

import java.util.HashMap;
import common.RPCConstantsAndServices;

public abstract class PersistentRoot implements AbstractPersistentRoot {

  private long id; 

  public PersistentRoot(long id) {
    this.id = id;
  }

  public long getId(){
    return this.id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public boolean equals(Object object){
    return this.isTheSameAs(object);
  }
  public boolean isTheSameAs(Object object){
    AbstractPersistentRoot argument;
    if(object == null) return false;
    try {
      argument = (AbstractPersistentRoot)object;
      return this.id == argument.getId() && this.getClassId() == argument.getClassId();
    }catch (ClassCastException cce) {
      return false;
    } 
  }
  public int hashCode(){
	return new Long(id).intValue();
  }
  
  abstract public void setDelayed$Persistence(boolean b) throws PersistenceException;
  abstract public boolean isDelayed$Persistence() throws PersistenceException;

  public abstract long getClassId();
  public abstract PersistentRoot getTheObject()  throws PersistenceException;
  public abstract HashMap<String, Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException;
  public abstract HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException;

  public abstract boolean hasEssentialFields() throws PersistenceException;

  public abstract String toString(boolean inner)throws PersistenceException;

  public void delete$Me() throws PersistenceException{
	  if (!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().dltObjct(this);
  }
  	
  public String createProxiInformation(boolean asLeaf, boolean withLeafInfo) throws PersistenceException {
	  return RPCConstantsAndServices.createProxiRepresentation(this.getClassId(), this.getId(), 
			  												   this.getIconInfo(), (asLeaf ? 0 : this.getLeafInfo()), this.toString());
  }

  public int getLeafInfo() throws PersistenceException {
	  return 1;
  }

  abstract public int getIconInfo() throws PersistenceException;
}
