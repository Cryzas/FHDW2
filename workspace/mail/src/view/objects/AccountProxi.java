package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountProxi extends abstractAccProxi implements AccountView{
    
    public AccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi InBox = null;
        String InBox$String = (String)resultTable.get("InBox");
        if (InBox$String != null) {
            common.ProxiInformation InBox$Info = common.RPCConstantsAndServices.createProxiInformation(InBox$String);
            InBox = view.objects.ViewProxi.createProxi(InBox$Info,connectionKey);
            InBox.setToString(InBox$Info.getToString());
        }
        ViewProxi OutBox = null;
        String OutBox$String = (String)resultTable.get("OutBox");
        if (OutBox$String != null) {
            common.ProxiInformation OutBox$Info = common.RPCConstantsAndServices.createProxiInformation(OutBox$String);
            OutBox = view.objects.ViewProxi.createProxi(OutBox$Info,connectionKey);
            OutBox.setToString(OutBox$Info.getToString());
        }
        ViewProxi drafts = null;
        String drafts$String = (String)resultTable.get("drafts");
        if (drafts$String != null) {
            common.ProxiInformation drafts$Info = common.RPCConstantsAndServices.createProxiInformation(drafts$String);
            drafts = view.objects.ViewProxi.createProxi(drafts$Info,connectionKey);
            drafts.setToString(drafts$Info.getToString());
        }
        java.util.Vector<String> folders_string = (java.util.Vector<String>)resultTable.get("folders");
        java.util.Vector<FolderView> folders = ViewProxi.getProxiVector(folders_string, connectionKey);
        AccountView result$$ = new Account((String)name,(FolderView)InBox,(FolderView)OutBox,(FolderView)drafts,folders, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getInBox() != null) return new InBoxAccountWrapper(this, originalIndex, (ViewRoot)this.getInBox());
        if(this.getInBox() != null) index = index - 1;
        if(index == 0 && this.getOutBox() != null) return new OutBoxAccountWrapper(this, originalIndex, (ViewRoot)this.getOutBox());
        if(this.getOutBox() != null) index = index - 1;
        if(index == 0 && this.getDrafts() != null) return new DraftsAccountWrapper(this, originalIndex, (ViewRoot)this.getDrafts());
        if(this.getDrafts() != null) index = index - 1;
        if(index < this.getFolders().size()) return new FoldersAccountWrapper(this, originalIndex, (ViewRoot)this.getFolders().get(index));
        index = index - this.getFolders().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getInBox() == null ? 0 : 1)
            + (this.getOutBox() == null ? 0 : 1)
            + (this.getDrafts() == null ? 0 : 1)
            + (this.getFolders().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getInBox() == null ? true : false)
            && (this.getOutBox() == null ? true : false)
            && (this.getDrafts() == null ? true : false)
            && (this.getFolders().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getInBox() != null && this.getInBox().equals(child)) return result;
        if(this.getInBox() != null) result = result + 1;
        if(this.getOutBox() != null && this.getOutBox().equals(child)) return result;
        if(this.getOutBox() != null) result = result + 1;
        if(this.getDrafts() != null && this.getDrafts().equals(child)) return result;
        if(this.getDrafts() != null) result = result + 1;
        java.util.Iterator<?> getFoldersIterator = this.getFolders().iterator();
        while(getFoldersIterator.hasNext()){
            if(getFoldersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public FolderView getInBox()throws ModelException{
        return ((Account)this.getTheObject()).getInBox();
    }
    public void setInBox(FolderView newValue) throws ModelException {
        ((Account)this.getTheObject()).setInBox(newValue);
    }
    public FolderView getOutBox()throws ModelException{
        return ((Account)this.getTheObject()).getOutBox();
    }
    public void setOutBox(FolderView newValue) throws ModelException {
        ((Account)this.getTheObject()).setOutBox(newValue);
    }
    public FolderView getDrafts()throws ModelException{
        return ((Account)this.getTheObject()).getDrafts();
    }
    public void setDrafts(FolderView newValue) throws ModelException {
        ((Account)this.getTheObject()).setDrafts(newValue);
    }
    public java.util.Vector<FolderView> getFolders()throws ModelException{
        return ((Account)this.getTheObject()).getFolders();
    }
    public void setFolders(java.util.Vector<FolderView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setFolders(newValue);
    }
    
    public void accept(abstractAccVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends view.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends view.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
