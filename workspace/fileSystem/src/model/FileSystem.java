
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class FileSystem extends PersistentObject implements PersistentFileSystem{
    
    private static FileSystem4Public theFileSystem = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static FileSystem4Public getTheFileSystem() throws PersistenceException{
        if (theFileSystem == null || reset$For$Test){
            if (reset$For$Test) theFileSystem = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            FileSystem4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theFileSystemFacade.getTheFileSystem();
                            theFileSystem = proxi;
                            if(proxi.getId() < 0) {
                                ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                                proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                                proxi.initializeOnCreation();
                            }
                        } catch (PersistenceException e){
                            exception = e;
                        } finally {
                            $$lock.notify();
                        }
                        
                    }
                }
                FileSystem4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theFileSystem== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theFileSystem;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theFileSystem;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot systemRoot = (AbstractPersistentRoot)this.getSystemRoot();
            if (systemRoot != null) {
                result.put("systemRoot", systemRoot.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    systemRoot.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && systemRoot.hasEssentialFields())systemRoot.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot clipBoard = (AbstractPersistentRoot)this.getClipBoard();
            if (clipBoard != null) {
                result.put("clipBoard", clipBoard.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    clipBoard.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && clipBoard.hasEssentialFields())clipBoard.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public FileSystem provideCopy() throws PersistenceException{
        FileSystem result = this;
        result = new FileSystem(this.systemRoot, 
                                this.clipBoard, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentDirectory systemRoot;
    protected PersistentClipBoard clipBoard;
    protected PersistentFileSystem This;
    
    public FileSystem(PersistentDirectory systemRoot,PersistentClipBoard clipBoard,PersistentFileSystem This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.systemRoot = systemRoot;
        this.clipBoard = clipBoard;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public Directory4Public getSystemRoot() throws PersistenceException {
        return this.systemRoot;
    }
    public void setSystemRoot(Directory4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.systemRoot)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.systemRoot = (PersistentDirectory)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFileSystemFacade.systemRootSet(this.getId(), newValue);
        }
    }
    public ClipBoard4Public getClipBoard() throws PersistenceException {
        return this.clipBoard;
    }
    public void setClipBoard(ClipBoard4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.clipBoard)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.clipBoard = (PersistentClipBoard)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFileSystemFacade.clipBoardSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentFileSystem newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFileSystem)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFileSystemFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentFileSystem getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFileSystem result = (PersistentFileSystem)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentFileSystem)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFileSystem(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFileSystem(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFileSystem(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFileSystem(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSystemRoot() != null) return 1;
        if (this.getClipBoard() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentFileSystem)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setSystemRoot(Directory.createDirectory(common.Constants.RootDirectoryName));
        getThis().setClipBoard(ClipBoard.createClipBoard());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
