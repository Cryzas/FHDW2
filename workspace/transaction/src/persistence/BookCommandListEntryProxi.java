package persistence;

public class BookCommandListEntryProxi extends BookCommandProxi implements PersistentBookCommandListEntryProxi {

  long entryId;

  public BookCommandListEntryProxi(long objectId, long entryId) {
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