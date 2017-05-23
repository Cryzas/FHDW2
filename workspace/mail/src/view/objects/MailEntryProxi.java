package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MailEntryProxi extends MailProxi implements MailEntryView{
    
    public MailEntryProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MailEntryView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> receivers_string = (java.util.Vector<String>)resultTable.get("receivers");
        java.util.Vector<AccountWrapperView> receivers = ViewProxi.getProxiVector(receivers_string, connectionKey);
        String subject = (String)resultTable.get("subject");
        String text = (String)resultTable.get("text");
        ViewProxi sender = null;
        String sender$String = (String)resultTable.get("sender");
        if (sender$String != null) {
            common.ProxiInformation sender$Info = common.RPCConstantsAndServices.createProxiInformation(sender$String);
            sender = view.objects.ViewProxi.createProxi(sender$Info,connectionKey);
            sender.setToString(sender$Info.getToString());
        }
        MailEntryView result$$ = new MailEntry(receivers,(String)subject,(String)text,(AccountWrapperView)sender, this.getId(), this.getClassId());
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
        if(index == 0 && this.getSender() != null) return new SenderMailEntryWrapper(this, originalIndex, (ViewRoot)this.getSender());
        if(this.getSender() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getReceivers().size())
            + (this.getSender() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getReceivers().size() == 0)
            && (this.getSender() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getReceiversIterator = this.getReceivers().iterator();
        while(getReceiversIterator.hasNext()){
            if(getReceiversIterator.next().equals(child)) return result;
            result = result + 1;
        }
        if(this.getSender() != null && this.getSender().equals(child)) return result;
        if(this.getSender() != null) result = result + 1;
        return -1;
    }
    
    public AccountWrapperView getSender()throws ModelException{
        return ((MailEntry)this.getTheObject()).getSender();
    }
    public void setSender(AccountWrapperView newValue) throws ModelException {
        ((MailEntry)this.getTheObject()).setSender(newValue);
    }
    
    public void accept(MailVisitor visitor) throws ModelException {
        visitor.handleMailEntry(this);
    }
    public <R> R accept(MailReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMailEntry(this);
    }
    public <E extends view.UserException>  void accept(MailExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMailEntry(this);
    }
    public <R, E extends view.UserException> R accept(MailReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMailEntry(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMailEntry(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMailEntry(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMailEntry(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMailEntry(this);
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
