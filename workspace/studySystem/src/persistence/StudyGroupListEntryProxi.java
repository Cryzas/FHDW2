package persistence;

public class StudyGroupListEntryProxi extends StudyGroupProxi implements PersistentStudyGroupListEntryProxi {

  long entryId;

  public StudyGroupListEntryProxi(long objectId, long entryId) {
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