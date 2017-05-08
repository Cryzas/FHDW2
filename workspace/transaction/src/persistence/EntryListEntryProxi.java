package persistence;

public abstract class EntryListEntryProxi extends EntryProxi implements PersistentEntryListEntryProxi {

  long entryId;

  public EntryListEntryProxi(long objectId, long entryId) {
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