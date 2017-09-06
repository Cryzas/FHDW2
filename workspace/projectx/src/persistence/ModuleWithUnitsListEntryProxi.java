package persistence;

public class ModuleWithUnitsListEntryProxi extends ModuleWithUnitsProxi implements PersistentModuleWithUnitsListEntryProxi {

  long entryId;

  public ModuleWithUnitsListEntryProxi(long objectId, long entryId) {
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