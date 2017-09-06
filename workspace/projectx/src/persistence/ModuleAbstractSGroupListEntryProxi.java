package persistence;

public abstract class ModuleAbstractSGroupListEntryProxi extends ModuleAbstractSGroupProxi implements PersistentModuleAbstractSGroupListEntryProxi {

  long entryId;

  public ModuleAbstractSGroupListEntryProxi(long objectId, long entryId) {
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