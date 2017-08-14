package persistence;

public class AddModuleCommandListEntryProxi extends AddModuleCommandProxi implements PersistentAddModuleCommandListEntryProxi {

  long entryId;

  public AddModuleCommandListEntryProxi(long objectId, long entryId) {
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