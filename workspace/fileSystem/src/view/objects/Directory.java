
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Directory extends view.objects.Containee implements DirectoryView{
    
    protected java.util.Vector<ContaineeView> contents;
    
    public Directory(String name,java.util.Vector<ContaineeView> contents,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,id, classId);
        this.contents = contents;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ContaineeView> getContents()throws ModelException{
        return this.contents;
    }
    public void setContents(java.util.Vector<ContaineeView> newValue) throws ModelException {
        this.contents = newValue;
    }
    
    public void accept(ContaineeVisitor visitor) throws ModelException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(ContaineeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDirectory(this);
    }
    public <E extends view.UserException>  void accept(ContaineeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends view.UserException> R accept(ContaineeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDirectory(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDirectory(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDirectory(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDirectory(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDirectory(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> contents = this.getContents();
        if (contents != null) {
            ViewObject.resolveVectorProxies(contents, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getContents().size()) return new ContentsDirectoryWrapper(this, originalIndex, (ViewRoot)this.getContents().get(index));
        index = index - this.getContents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getContents().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getContents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getContentsIterator = this.getContents().iterator();
        while(getContentsIterator.hasNext()){
            if(getContentsIterator.next().equals(child)) return result;
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
