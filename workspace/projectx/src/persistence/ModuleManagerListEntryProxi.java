package persistence;

public class ModuleManagerListEntryProxi extends ModuleManagerProxi implements PersistentModuleManagerListEntryProxi {

  long entryId;

  public ModuleManagerListEntryProxi(long objectId, long entryId) {
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