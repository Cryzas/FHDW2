package persistence;

public class StudyGroupServiceGroupManagerListEntryProxi extends StudyGroupServiceGroupManagerProxi implements PersistentStudyGroupServiceGroupManagerListEntryProxi {

  long entryId;

  public StudyGroupServiceGroupManagerListEntryProxi(long objectId, long entryId) {
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