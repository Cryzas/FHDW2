package persistence;

public class BTrueListEntryProxi extends BTrueProxi implements PersistentBTrueListEntryProxi {

  long entryId;

  public BTrueListEntryProxi(long objectId, long entryId) {
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