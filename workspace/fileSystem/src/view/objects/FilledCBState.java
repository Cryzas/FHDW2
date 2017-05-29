
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class FilledCBState extends view.objects.ClipBoardState implements FilledCBStateView{
    
    protected ContaineeView contents;
    
    public FilledCBState(ContaineeView contents,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.contents = contents;        
    }
    
    static public long getTypeId() {
        return 128;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ContaineeView getContents()throws ModelException{
        return this.contents;
    }
    public void setContents(ContaineeView newValue) throws ModelException {
        this.contents = newValue;
    }
    
    public void accept(ClipBoardStateVisitor visitor) throws ModelException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends view.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends view.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFilledCBState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleFilledCBState(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ContaineeView contents = this.getContents();
        if (contents != null) {
            ((ViewProxi)contents).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(contents.getClassId(), contents.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getContents() != null) return new ContentsFilledCBStateWrapper(this, originalIndex, (ViewRoot)this.getContents());
        if(this.getContents() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getContents() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getContents() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getContents() != null && this.getContents().equals(child)) return result;
        if(this.getContents() != null) result = result + 1;
        return -1;
    }
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
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
