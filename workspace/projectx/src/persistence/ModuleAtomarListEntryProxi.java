package persistence;

public class ModuleAtomarListEntryProxi extends ModuleAtomarProxi implements PersistentModuleAtomarListEntryProxi {

  long entryId;

  public ModuleAtomarListEntryProxi(long objectId, long entryId) {
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