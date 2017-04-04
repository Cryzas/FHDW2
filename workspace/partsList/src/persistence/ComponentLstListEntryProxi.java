package persistence;

public class ComponentLstListEntryProxi extends ComponentLstProxi implements PersistentComponentLstListEntryProxi {

  long entryId;

  public ComponentLstListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}