package persistence;

public class ProgramModuleServiceProgramManagerListEntryProxi extends ProgramModuleServiceProgramManagerProxi implements PersistentProgramModuleServiceProgramManagerListEntryProxi {

  long entryId;

  public ProgramModuleServiceProgramManagerListEntryProxi(long objectId, long entryId) {
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