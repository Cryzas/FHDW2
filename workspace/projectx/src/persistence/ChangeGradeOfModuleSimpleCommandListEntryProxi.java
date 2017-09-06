package persistence;

public class ChangeGradeOfModuleSimpleCommandListEntryProxi extends ChangeGradeOfModuleSimpleCommandProxi implements PersistentChangeGradeOfModuleSimpleCommandListEntryProxi {

  long entryId;

  public ChangeGradeOfModuleSimpleCommandListEntryProxi(long objectId, long entryId) {
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