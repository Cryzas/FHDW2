package persistence;

public abstract class BookableListEntryProxi extends BookableProxi implements PersistentBookableListEntryProxi {

  long entryId;

  public BookableListEntryProxi(long objectId, long entryId) {
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