package persistence;

public class NotBookedListEntryProxi extends NotBookedProxi implements PersistentNotBookedListEntryProxi {

  long entryId;

  public NotBookedListEntryProxi(long objectId, long entryId) {
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