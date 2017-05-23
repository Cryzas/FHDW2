package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class FolderProxi extends ViewProxi implements FolderView{
    
    public FolderProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public FolderView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        java.util.Vector<String> mails_string = (java.util.Vector<String>)resultTable.get("mails");
        java.util.Vector<MailView> mails = ViewProxi.getProxiVector(mails_string, connectionKey);
        FolderView result$$ = new Folder((String)name,mails, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getMails().size()) return new MailsFolderWrapper(this, originalIndex, (ViewRoot)this.getMails().get(index));
        index = index - this.getMails().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMails().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMails().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getMailsIterator = this.getMails().iterator();
        while(getMailsIterator.hasNext()){
            if(getMailsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName()throws ModelException{
        return ((Folder)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Folder)this.getTheObject()).setName(newValue);
    }
    public java.util.Vector<MailView> getMails()throws ModelException{
        return ((Folder)this.getTheObject()).getMails();
    }
    public void setMails(java.util.Vector<MailView> newValue) throws ModelException {
        ((Folder)this.getTheObject()).setMails(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFolder(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFolder(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFolder(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFolder(this);
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
