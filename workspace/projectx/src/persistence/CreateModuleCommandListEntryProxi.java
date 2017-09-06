package persistence;

public class CreateModuleCommandListEntryProxi extends CreateModuleCommandProxi implements PersistentCreateModuleCommandListEntryProxi {

  long entryId;

  public CreateModuleCommandListEntryProxi(long objectId, long entryId) {
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