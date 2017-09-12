package persistence;

public class BFalseListEntryProxi extends BFalseProxi implements PersistentBFalseListEntryProxi {

  long entryId;

  public BFalseListEntryProxi(long objectId, long entryId) {
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