package persistence;

public class QuantifiedComponentListEntryProxi extends QuantifiedComponentProxi implements PersistentQuantifiedComponentListEntryProxi {

  long entryId;

  public QuantifiedComponentListEntryProxi(long objectId, long entryId) {
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