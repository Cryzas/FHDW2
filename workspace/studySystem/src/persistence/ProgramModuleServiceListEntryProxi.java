package persistence;

public class ProgramModuleServiceListEntryProxi extends ProgramModuleServiceProxi implements PersistentProgramModuleServiceListEntryProxi {

  long entryId;

  public ProgramModuleServiceListEntryProxi(long objectId, long entryId) {
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