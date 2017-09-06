package persistence;

public class ModuleWithUnitsSGroupListEntryProxi extends ModuleWithUnitsSGroupProxi implements PersistentModuleWithUnitsSGroupListEntryProxi {

  long entryId;

  public ModuleWithUnitsSGroupListEntryProxi(long objectId, long entryId) {
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