package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DraftProxi extends MailProxi implements DraftView{
    
    public DraftProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public DraftView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> receivers_string = (java.util.Vector<String>)resultTable.get("receivers");
        java.util.Vector<AccountWrapperView> receivers = ViewProxi.getProxiVector(receivers_string, connectionKey);
        String subject = (String)resultTable.get("subject");
        String text = (String)resultTable.get("text");
        DraftView result$$ = new Draft(receivers,(String)subject,(String)text, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getReceivers().size()) return new ReceiversMailWrapper(this, originalIndex, (ViewRoot)this.getReceivers().get(index));
        index = index - this.getReceivers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getReceivers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getReceivers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getReceiversIterator = this.getReceivers().iterator();
        while(getReceiversIterator.hasNext()){
            if(getReceiversIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    
    public void accept(MailVisitor visitor) throws ModelException {
        visitor.handleDraft(this);
    }
    public <R> R accept(MailReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDraft(this);
    }
    public <E extends view.UserException>  void accept(MailExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDraft(this);
    }
    public <R, E extends view.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDraft(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDraft(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDraft(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDraft(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDraft(this);
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
