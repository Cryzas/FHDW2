package persistence;

public class ManagerListEntryProxi extends ManagerProxi implements PersistentManagerListEntryProxi {

  long entryId;

  public ManagerListEntryProxi(long objectId, long entryId) {
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