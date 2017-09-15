package persistence;

public class ModuleAtomarSGroupListEntryProxi extends ModuleAtomarSGroupProxi implements PersistentModuleAtomarSGroupListEntryProxi {

  long entryId;

  public ModuleAtomarSGroupListEntryProxi(long objectId, long entryId) {
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