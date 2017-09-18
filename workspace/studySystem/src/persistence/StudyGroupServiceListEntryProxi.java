package persistence;

public class StudyGroupServiceListEntryProxi extends StudyGroupServiceProxi implements PersistentStudyGroupServiceListEntryProxi {

  long entryId;

  public StudyGroupServiceListEntryProxi(long objectId, long entryId) {
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