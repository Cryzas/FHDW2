package persistence;

public class StudentManageServiceStudentManagerListEntryProxi extends StudentManageServiceStudentManagerProxi implements PersistentStudentManageServiceStudentManagerListEntryProxi {

  long entryId;

  public StudentManageServiceStudentManagerListEntryProxi(long objectId, long entryId) {
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