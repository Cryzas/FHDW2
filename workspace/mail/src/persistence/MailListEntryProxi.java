package persistence;

public abstract class MailListEntryProxi extends MailProxi implements PersistentMailListEntryProxi {

  long entryId;

  public MailListEntryProxi(long objectId, long entryId) {
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