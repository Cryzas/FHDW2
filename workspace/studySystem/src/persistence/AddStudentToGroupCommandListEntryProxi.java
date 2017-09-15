package persistence;

public class AddStudentToGroupCommandListEntryProxi extends AddStudentToGroupCommandProxi implements PersistentAddStudentToGroupCommandListEntryProxi {

  long entryId;

  public AddStudentToGroupCommandListEntryProxi(long objectId, long entryId) {
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