package persistence;

public class StudentListEntryProxi extends StudentProxi implements PersistentStudentListEntryProxi {

  long entryId;

  public StudentListEntryProxi(long objectId, long entryId) {
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