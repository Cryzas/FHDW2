
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class File extends model.Containee implements PersistentFile{
    
    
    public static File4Public createFile(String name) throws PersistenceException{
        return createFile(name,false);
    }
    
    public static File4Public createFile(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentFile result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFileFacade
                .newDelayedFile(name,"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFileFacade
                .newFile(name,"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static File4Public createFile(String name,boolean delayed$Persistence,File4Public This) throws PersistenceException {
        PersistentFile result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFileFacade
                .newDelayedFile(name,"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFileFacade
                .newFile(name,"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("contents", this.getContents());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public File provideCopy() throws PersistenceException{
        File result = this;
        result = new File(this.name, 
                          this.This, 
                          this.contents, 
                          this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String contents;
    
    public File(String name,PersistentContainee This,String contents,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentContainee)This,id);
        this.contents = contents;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theFileFacade
            .newFile(name,contents,this.getId());
        super.store();
        
    }
    
    public String getContents() throws PersistenceException {
        return this.contents;
    }
    public void setContents(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theFileFacade.contentsSet(this.getId(), newValue);
        this.contents = newValue;
    }
    public PersistentFile getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFile result = (PersistentFile)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentFile)this.This;
    }
    
    public void accept(ContaineeVisitor visitor) throws PersistenceException {
        visitor.handleFile(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFile(this);
    }
    public <E extends model.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFile(this);
    }
    public <R, E extends model.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFile(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFile(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFile(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFile(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFile(this);
    }
    public void accept(FileTreeHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleFile(this);
    }
    public <R> R accept(FileTreeHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFile(this);
    }
    public <E extends model.UserException>  void accept(FileTreeHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFile(this);
    }
    public <R, E extends model.UserException> R accept(FileTreeHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFile(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void changeContents(final String newContents, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeContentsCommand4Public command = model.meta.ChangeContentsCommand.createChangeContentsCommand(newContents, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFile)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.File$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeContents(final String newContents) 
				throws PersistenceException{
    	getThis().setContents(newContents);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
