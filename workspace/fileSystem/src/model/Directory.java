
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Directory extends model.Containee implements PersistentDirectory{
    
    
    public static Directory4Public createDirectory(String name) throws PersistenceException{
        return createDirectory(name,false);
    }
    
    public static Directory4Public createDirectory(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentDirectory result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade
                .newDelayedDirectory(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade
                .newDirectory(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Directory4Public createDirectory(String name,boolean delayed$Persistence,Directory4Public This) throws PersistenceException {
        PersistentDirectory result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade
                .newDelayedDirectory(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDirectoryFacade
                .newDirectory(name,-1);
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
            result.put("contents", this.getContents().getValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Directory provideCopy() throws PersistenceException{
        Directory result = this;
        result = new Directory(this.name, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Directory_ContentsProxi contents;
    
    public Directory(String name,PersistentContainee This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentContainee)This,id);
        this.contents = new Directory_ContentsProxi(this);        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 117) ConnectionHandler.getTheConnectionHandler().theDirectoryFacade
            .newDirectory(name,this.getId());
        super.store();
        this.getContents().store();
        
    }
    
    public Directory_ContentsProxi getContents() throws PersistenceException {
        return this.contents;
    }
    public PersistentDirectory getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDirectory result = (PersistentDirectory)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentDirectory)this.This;
    }
    
    public void accept(ContaineeVisitor visitor) throws PersistenceException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDirectory(this);
    }
    public <E extends model.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends model.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDirectory(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDirectory(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDirectory(this);
    }
    public void accept(FileTreeHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(FileTreeHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDirectory(this);
    }
    public <E extends model.UserException>  void accept(FileTreeHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends model.UserException> R accept(FileTreeHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDirectory(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if( this.getContents().getValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addContainee(final Containee4Public containee, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddContaineeCommand4Public command = model.meta.AddContaineeCommand.createAddContaineeCommand(nw, d1170);
		command.setContainee(containee);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<Containee4Public> iterator0 = getThis().getContents().getValues().iterator();
		while(iterator0.hasNext())
			if(((FileTreeHIERARCHY)iterator0.next()).containsFileTree(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDirectory)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$contents$$Directory = strategy.Directory$$contents$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getContents().getValues().iterator();
		while (iterator$$.hasNext()){
			Containee4Public current$$Field = (Containee4Public)iterator$$.next();
			T current$$ = current$$Field.strategyFileTree(strategy);
			result$$contents$$Directory = strategy.Directory$$contents$$consolidate(getThis(), result$$contents$$Directory, current$$);
		}
		T result = strategy.Directory$$finalize(getThis() ,result$$contents$$Directory);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addContainee(final Containee4Public containee) 
				throws model.FileSystemException, model.CycleException, PersistenceException{
        Containee4Public oldContainee = getThis().getContents().put(containee.getName(), containee);
        if (oldContainee != null) 
        	throw new FileSystemException(common.Constants.ComponentAlreadyExistsMessage);
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
