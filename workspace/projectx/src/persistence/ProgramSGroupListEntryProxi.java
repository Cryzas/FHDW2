package persistence;

public class ProgramSGroupListEntryProxi extends ProgramSGroupProxi implements PersistentProgramSGroupListEntryProxi {

  long entryId;

  public ProgramSGroupListEntryProxi(long objectId, long entryId) {
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