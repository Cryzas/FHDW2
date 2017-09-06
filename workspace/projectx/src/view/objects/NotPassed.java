
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class NotPassed extends view.objects.GradesInSimple implements NotPassedView{
    
    
    public NotPassed(long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);        
    }
    
    static public long getTypeId() {
        return 219;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(GradesInSimpleVisitor visitor) throws ModelException {
        visitor.handleNotPassed(this);
    }
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotPassed(this);
    }
    public <E extends view.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotPassed(this);
    }
    public <R, E extends view.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotPassed(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException {
        visitor.handleNotPassed(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotPassed(this);
    }
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotPassed(this);
    }
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotPassed(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotPassed(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotPassed(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotPassed(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotPassed(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
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
