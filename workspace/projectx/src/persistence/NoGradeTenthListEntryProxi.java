package persistence;

public class NoGradeTenthListEntryProxi extends NoGradeTenthProxi implements PersistentNoGradeTenthListEntryProxi {

  long entryId;

  public NoGradeTenthListEntryProxi(long objectId, long entryId) {
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