package persistence;

public class BookedListEntryProxi extends BookedProxi implements PersistentBookedListEntryProxi {

  long entryId;

  public BookedListEntryProxi(long objectId, long entryId) {
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