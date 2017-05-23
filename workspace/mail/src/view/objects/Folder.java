
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Folder extends ViewObject implements FolderView{
    
    protected String name;
    protected java.util.Vector<MailView> mails;
    
    public Folder(String name,java.util.Vector<MailView> mails,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.mails = mails;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public java.util.Vector<MailView> getMails()throws ModelException{
        return this.mails;
    }
    public void setMails(java.util.Vector<MailView> newValue) throws ModelException {
        this.mails = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> mails = this.getMails();
        if (mails != null) {
            ViewObject.resolveVectorProxies(mails, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
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
            this.setName(newValue);
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
