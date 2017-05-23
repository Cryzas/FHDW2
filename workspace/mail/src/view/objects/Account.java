
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Account extends view.objects.abstractAcc implements AccountView{
    
    protected FolderView InBox;
    protected FolderView OutBox;
    protected FolderView drafts;
    protected java.util.Vector<FolderView> folders;
    
    public Account(String name,FolderView InBox,FolderView OutBox,FolderView drafts,java.util.Vector<FolderView> folders,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,id, classId);
        this.InBox = InBox;
        this.OutBox = OutBox;
        this.drafts = drafts;
        this.folders = folders;        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public FolderView getInBox()throws ModelException{
        return this.InBox;
    }
    public void setInBox(FolderView newValue) throws ModelException {
        this.InBox = newValue;
    }
    public FolderView getOutBox()throws ModelException{
        return this.OutBox;
    }
    public void setOutBox(FolderView newValue) throws ModelException {
        this.OutBox = newValue;
    }
    public FolderView getDrafts()throws ModelException{
        return this.drafts;
    }
    public void setDrafts(FolderView newValue) throws ModelException {
        this.drafts = newValue;
    }
    public java.util.Vector<FolderView> getFolders()throws ModelException{
        return this.folders;
    }
    public void setFolders(java.util.Vector<FolderView> newValue) throws ModelException {
        this.folders = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        FolderView InBox = this.getInBox();
        if (InBox != null) {
            ((ViewProxi)InBox).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(InBox.getClassId(), InBox.getId())));
        }
        FolderView OutBox = this.getOutBox();
        if (OutBox != null) {
            ((ViewProxi)OutBox).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(OutBox.getClassId(), OutBox.getId())));
        }
        FolderView drafts = this.getDrafts();
        if (drafts != null) {
            ((ViewProxi)drafts).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(drafts.getClassId(), drafts.getId())));
        }
        java.util.Vector<?> folders = this.getFolders();
        if (folders != null) {
            ViewObject.resolveVectorProxies(folders, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
