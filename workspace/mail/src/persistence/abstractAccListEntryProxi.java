package persistence;

public abstract class abstractAccListEntryProxi extends abstractAccProxi implements PersistentabstractAccListEntryProxi {

  long entryId;

  public abstractAccListEntryProxi(long objectId, long entryId) {
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