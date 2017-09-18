package persistence;

public class ProgramModuleServiceModuleManagerListEntryProxi extends ProgramModuleServiceModuleManagerProxi implements PersistentProgramModuleServiceModuleManagerListEntryProxi {

  long entryId;

  public ProgramModuleServiceModuleManagerListEntryProxi(long objectId, long entryId) {
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