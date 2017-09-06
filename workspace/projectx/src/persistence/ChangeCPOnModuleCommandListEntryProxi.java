package persistence;

public class ChangeCPOnModuleCommandListEntryProxi extends ChangeCPOnModuleCommandProxi implements PersistentChangeCPOnModuleCommandListEntryProxi {

  long entryId;

  public ChangeCPOnModuleCommandListEntryProxi(long objectId, long entryId) {
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