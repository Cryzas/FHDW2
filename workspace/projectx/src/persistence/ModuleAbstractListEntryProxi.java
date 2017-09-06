package persistence;

public abstract class ModuleAbstractListEntryProxi extends ModuleAbstractProxi implements PersistentModuleAbstractListEntryProxi {

  long entryId;

  public ModuleAbstractListEntryProxi(long objectId, long entryId) {
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