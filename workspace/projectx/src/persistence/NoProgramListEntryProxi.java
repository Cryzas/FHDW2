package persistence;

public class NoProgramListEntryProxi extends NoProgramProxi implements PersistentNoProgramListEntryProxi {

  long entryId;

  public NoProgramListEntryProxi(long objectId, long entryId) {
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