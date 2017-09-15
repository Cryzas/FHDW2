package persistence;

public abstract class ModuleAbstractStudentListEntryProxi extends ModuleAbstractStudentProxi implements PersistentModuleAbstractStudentListEntryProxi {

  long entryId;

  public ModuleAbstractStudentListEntryProxi(long objectId, long entryId) {
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