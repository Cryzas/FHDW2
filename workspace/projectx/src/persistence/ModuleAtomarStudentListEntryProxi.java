package persistence;

public class ModuleAtomarStudentListEntryProxi extends ModuleAtomarStudentProxi implements PersistentModuleAtomarStudentListEntryProxi {

  long entryId;

  public ModuleAtomarStudentListEntryProxi(long objectId, long entryId) {
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