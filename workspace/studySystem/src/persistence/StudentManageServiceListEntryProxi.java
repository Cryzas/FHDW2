package persistence;

public class StudentManageServiceListEntryProxi extends StudentManageServiceProxi implements PersistentStudentManageServiceListEntryProxi {

  long entryId;

  public StudentManageServiceListEntryProxi(long objectId, long entryId) {
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