package persistence;

public class ProgramStudentListEntryProxi extends ProgramStudentProxi implements PersistentProgramStudentListEntryProxi {

  long entryId;

  public ProgramStudentListEntryProxi(long objectId, long entryId) {
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