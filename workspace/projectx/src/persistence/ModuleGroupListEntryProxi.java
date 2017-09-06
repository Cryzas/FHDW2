package persistence;

public class ModuleGroupListEntryProxi extends ModuleGroupProxi implements PersistentModuleGroupListEntryProxi {

  long entryId;

  public ModuleGroupListEntryProxi(long objectId, long entryId) {
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