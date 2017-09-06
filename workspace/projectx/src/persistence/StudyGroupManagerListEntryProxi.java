package persistence;

public class StudyGroupManagerListEntryProxi extends StudyGroupManagerProxi implements PersistentStudyGroupManagerListEntryProxi {

  long entryId;

  public StudyGroupManagerListEntryProxi(long objectId, long entryId) {
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