
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Draft extends view.objects.Mail implements DraftView{
    
    
    public Draft(java.util.Vector<AccountWrapperView> receivers,String subject,String text,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(receivers,(String)subject,(String)text,id, classId);        
    }
    
    static public long getTypeId() {
        return 133;
    }
    
    public long getClassId() {
        return getTypeId();
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> receivers = this.getReceivers();
        if (receivers != null) {
            ViewObject.resolveVectorProxies(receivers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getSubjectIndex() throws ModelException {
        return 0 + this.getReceivers().size();
    }
    public int getTextIndex() throws ModelException {
        return 0 + this.getReceivers().size() + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "subject";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "text";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getSubject();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getText();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setSubject(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setText(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
