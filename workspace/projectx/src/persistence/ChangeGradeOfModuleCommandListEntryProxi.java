package persistence;

public class ChangeGradeOfModuleCommandListEntryProxi extends ChangeGradeOfModuleCommandProxi implements PersistentChangeGradeOfModuleCommandListEntryProxi {

  long entryId;

  public ChangeGradeOfModuleCommandListEntryProxi(long objectId, long entryId) {
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