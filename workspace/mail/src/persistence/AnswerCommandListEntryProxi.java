package persistence;

public class AnswerCommandListEntryProxi extends AnswerCommandProxi implements PersistentAnswerCommandListEntryProxi {

  long entryId;

  public AnswerCommandListEntryProxi(long objectId, long entryId) {
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