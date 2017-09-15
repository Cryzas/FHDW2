package persistence;

public class ProgramManagerListEntryProxi extends ProgramManagerProxi implements PersistentProgramManagerListEntryProxi {

  long entryId;

  public ProgramManagerListEntryProxi(long objectId, long entryId) {
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