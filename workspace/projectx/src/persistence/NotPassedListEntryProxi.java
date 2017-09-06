package persistence;

public class NotPassedListEntryProxi extends NotPassedProxi implements PersistentNotPassedListEntryProxi {

  long entryId;

  public NotPassedListEntryProxi(long objectId, long entryId) {
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