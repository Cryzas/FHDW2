package persistence;



import model.visitor.*;

public class FolderProxi extends PersistentProxi implements PersistentFolder{
    
    public FolderProxi(long objectId) {
        super(objectId);
    }
    public FolderProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 121;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentFolder)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentFolder)this.getTheObject()).setName(newValue);
    }
    public Folder_MailsProxi getMails() throws PersistenceException {
        return ((PersistentFolder)this.getTheObject()).getMails();
    }
    public PersistentFolder getThis() throws PersistenceException {
        return ((PersistentFolder)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFolder(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFolder(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFolder(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFolder(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFolder)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addMail(final Mail4Public mail) 
				throws PersistenceException{
        ((PersistentFolder)this.getTheObject()).addMail(mail);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFolder)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFolder)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFolder)this.getTheObject()).initializeOnInstantiation();
    }

    
}
