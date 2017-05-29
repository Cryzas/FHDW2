package persistence;

public class EmptyCBStateListEntryProxi extends EmptyCBStateProxi implements PersistentEmptyCBStateListEntryProxi {

  long entryId;

  public EmptyCBStateListEntryProxi(long objectId, long entryId) {
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