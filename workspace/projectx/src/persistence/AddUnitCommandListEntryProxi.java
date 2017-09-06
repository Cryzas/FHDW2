package persistence;

public class AddUnitCommandListEntryProxi extends AddUnitCommandProxi implements PersistentAddUnitCommandListEntryProxi {

  long entryId;

  public AddUnitCommandListEntryProxi(long objectId, long entryId) {
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