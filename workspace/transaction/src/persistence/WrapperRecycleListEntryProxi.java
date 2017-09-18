package persistence;

public class WrapperRecycleListEntryProxi extends WrapperRecycleProxi implements PersistentWrapperRecycleListEntryProxi {

  long entryId;

  public WrapperRecycleListEntryProxi(long objectId, long entryId) {
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