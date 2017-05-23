package persistence;

public class MailEntryListEntryProxi extends MailEntryProxi implements PersistentMailEntryListEntryProxi {

  long entryId;

  public MailEntryListEntryProxi(long objectId, long entryId) {
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