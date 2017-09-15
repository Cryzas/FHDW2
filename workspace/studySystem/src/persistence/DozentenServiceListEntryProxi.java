package persistence;

public class DozentenServiceListEntryProxi extends DozentenServiceProxi implements PersistentDozentenServiceListEntryProxi {

  long entryId;

  public DozentenServiceListEntryProxi(long objectId, long entryId) {
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