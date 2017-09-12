package persistence;

public class StudentServiceListEntryProxi extends StudentServiceProxi implements PersistentStudentServiceListEntryProxi {

  long entryId;

  public StudentServiceListEntryProxi(long objectId, long entryId) {
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