package persistence;

public class ChangeGradeCommandListEntryProxi extends ChangeGradeCommandProxi implements PersistentChangeGradeCommandListEntryProxi {

  long entryId;

  public ChangeGradeCommandListEntryProxi(long objectId, long entryId) {
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