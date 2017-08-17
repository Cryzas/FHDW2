package persistence;

public class ModuleWithUnitsStudentListEntryProxi extends ModuleWithUnitsStudentProxi implements PersistentModuleWithUnitsStudentListEntryProxi {

  long entryId;

  public ModuleWithUnitsStudentListEntryProxi(long objectId, long entryId) {
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