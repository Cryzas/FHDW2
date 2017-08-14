package persistence;

public class ChangeCPOnUnitCommandListEntryProxi extends ChangeCPOnUnitCommandProxi implements PersistentChangeCPOnUnitCommandListEntryProxi {

  long entryId;

  public ChangeCPOnUnitCommandListEntryProxi(long objectId, long entryId) {
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