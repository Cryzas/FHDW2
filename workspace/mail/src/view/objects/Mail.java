
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public abstract class Mail extends ViewObject implements MailView{
    
    protected java.util.Vector<AccountWrapperView> receivers;
    protected String subject;
    protected String text;
    
    public Mail(java.util.Vector<AccountWrapperView> receivers,String subject,String text,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.receivers = receivers;
        this.subject = subject;
        this.text = text;        
    }
    
    public java.util.Vector<AccountWrapperView> getReceivers()throws ModelException{
        return this.receivers;
    }
    public void setReceivers(java.util.Vector<AccountWrapperView> newValue) throws ModelException {
        this.receivers = newValue;
    }
    public String getSubject()throws ModelException{
        return this.subject;
    }
    public void setSubject(String newValue) throws ModelException {
        this.subject = newValue;
    }
    public String getText()throws ModelException{
        return this.text;
    }
    public void setText(String newValue) throws ModelException {
        this.text = newValue;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
