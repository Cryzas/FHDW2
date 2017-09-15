package persistence;

public class PassedListEntryProxi extends PassedProxi implements PersistentPassedListEntryProxi {

  long entryId;

  public PassedListEntryProxi(long objectId, long entryId) {
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