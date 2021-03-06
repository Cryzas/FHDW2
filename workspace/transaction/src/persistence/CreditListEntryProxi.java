package persistence;

public class CreditListEntryProxi extends CreditProxi implements PersistentCreditListEntryProxi {

  long entryId;

  public CreditListEntryProxi(long objectId, long entryId) {
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