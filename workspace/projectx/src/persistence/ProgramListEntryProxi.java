package persistence;

public class ProgramListEntryProxi extends ProgramProxi implements PersistentProgramListEntryProxi {

  long entryId;

  public ProgramListEntryProxi(long objectId, long entryId) {
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