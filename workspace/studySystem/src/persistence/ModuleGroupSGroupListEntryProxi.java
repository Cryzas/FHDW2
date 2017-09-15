package persistence;

public class ModuleGroupSGroupListEntryProxi extends ModuleGroupSGroupProxi implements PersistentModuleGroupSGroupListEntryProxi {

  long entryId;

  public ModuleGroupSGroupListEntryProxi(long objectId, long entryId) {
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