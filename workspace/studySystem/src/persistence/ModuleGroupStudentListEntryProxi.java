package persistence;

public class ModuleGroupStudentListEntryProxi extends ModuleGroupStudentProxi implements PersistentModuleGroupStudentListEntryProxi {

  long entryId;

  public ModuleGroupStudentListEntryProxi(long objectId, long entryId) {
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