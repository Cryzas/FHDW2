package persistence;

public class NoAccountListEntryProxi extends NoAccountProxi implements PersistentNoAccountListEntryProxi {

  long entryId;

  public NoAccountListEntryProxi(long objectId, long entryId) {
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