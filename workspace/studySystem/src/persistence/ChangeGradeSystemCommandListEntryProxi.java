package persistence;

public class ChangeGradeSystemCommandListEntryProxi extends ChangeGradeSystemCommandProxi implements PersistentChangeGradeSystemCommandListEntryProxi {

  long entryId;

  public ChangeGradeSystemCommandListEntryProxi(long objectId, long entryId) {
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