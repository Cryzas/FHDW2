package persistence;

public class AddModuleToGroupCommandListEntryProxi extends AddModuleToGroupCommandProxi implements PersistentAddModuleToGroupCommandListEntryProxi {

  long entryId;

  public AddModuleToGroupCommandListEntryProxi(long objectId, long entryId) {
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