package persistence;

public class StudentManagerListEntryProxi extends StudentManagerProxi implements PersistentStudentManagerListEntryProxi {

  long entryId;

  public StudentManagerListEntryProxi(long objectId, long entryId) {
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