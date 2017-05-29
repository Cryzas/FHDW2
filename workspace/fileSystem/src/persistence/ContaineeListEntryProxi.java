package persistence;

public abstract class ContaineeListEntryProxi extends ContaineeProxi implements PersistentContaineeListEntryProxi {

  long entryId;

  public ContaineeListEntryProxi(long objectId, long entryId) {
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