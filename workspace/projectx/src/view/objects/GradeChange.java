
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class GradeChange extends ViewObject implements GradeChangeView{
    
    protected GradeView fromGrade;
    protected GradeView toGrade;
    protected java.util.Date dateOfChange;
    protected String comment;
    
    public GradeChange(GradeView fromGrade,GradeView toGrade,java.util.Date dateOfChange,String comment,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.fromGrade = fromGrade;
        this.toGrade = toGrade;
        this.dateOfChange = dateOfChange;
        this.comment = comment;        
    }
    
    static public long getTypeId() {
        return 276;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public GradeView getFromGrade()throws ModelException{
        return this.fromGrade;
    }
    public void setFromGrade(GradeView newValue) throws ModelException {
        this.fromGrade = newValue;
    }
    public GradeView getToGrade()throws ModelException{
        return this.toGrade;
    }
    public void setToGrade(GradeView newValue) throws ModelException {
        this.toGrade = newValue;
    }
    public java.util.Date getDateOfChange()throws ModelException{
        return this.dateOfChange;
    }
    public void setDateOfChange(java.util.Date newValue) throws ModelException {
        this.dateOfChange = newValue;
    }
    public String getComment()throws ModelException{
        return this.comment;
    }
    public void setComment(String newValue) throws ModelException {
        this.comment = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleGradeChange(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleGradeChange(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleGradeChange(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleGradeChange(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        GradeView fromGrade = this.getFromGrade();
        if (fromGrade != null) {
            ((ViewProxi)fromGrade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fromGrade.getClassId(), fromGrade.getId())));
        }
        GradeView toGrade = this.getToGrade();
        if (toGrade != null) {
            ((ViewProxi)toGrade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(toGrade.getClassId(), toGrade.getId())));
        }
        
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
