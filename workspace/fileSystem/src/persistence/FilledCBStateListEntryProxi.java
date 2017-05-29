package persistence;

public class FilledCBStateListEntryProxi extends FilledCBStateProxi implements PersistentFilledCBStateListEntryProxi {

  long entryId;

  public FilledCBStateListEntryProxi(long objectId, long entryId) {
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