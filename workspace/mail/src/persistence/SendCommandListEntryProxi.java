package persistence;

public class SendCommandListEntryProxi extends SendCommandProxi implements PersistentSendCommandListEntryProxi {

  long entryId;

  public SendCommandListEntryProxi(long objectId, long entryId) {
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