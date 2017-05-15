package persistence;

public abstract class AbstractTransferListEntryProxi extends AbstractTransferProxi implements PersistentAbstractTransferListEntryProxi {

  long entryId;

  public AbstractTransferListEntryProxi(long objectId, long entryId) {
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