package persistence;

public class CreateStudentCommandListEntryProxi extends CreateStudentCommandProxi implements PersistentCreateStudentCommandListEntryProxi {

  long entryId;

  public CreateStudentCommandListEntryProxi(long objectId, long entryId) {
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