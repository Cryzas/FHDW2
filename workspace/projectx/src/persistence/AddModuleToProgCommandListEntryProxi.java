package persistence;

public class AddModuleToProgCommandListEntryProxi extends AddModuleToProgCommandProxi implements PersistentAddModuleToProgCommandListEntryProxi {

  long entryId;

  public AddModuleToProgCommandListEntryProxi(long objectId, long entryId) {
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