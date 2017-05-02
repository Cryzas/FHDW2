package persistence;

public class CreateMaterialCommandListEntryProxi extends CreateMaterialCommandProxi implements PersistentCreateMaterialCommandListEntryProxi {

  long entryId;

  public CreateMaterialCommandListEntryProxi(long objectId, long entryId) {
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