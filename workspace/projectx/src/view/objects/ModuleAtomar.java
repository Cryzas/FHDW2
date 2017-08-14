
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleAtomar extends view.objects.ModuleAbstract implements ModuleAtomarView{
    
    protected common.Fraction ownCreditPoints;
    
    public ModuleAtomar(String name,common.Fraction creditPoints,common.Fraction ownCreditPoints,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)creditPoints,id, classId);
        this.ownCreditPoints = ownCreditPoints;        
    }
    
    static public long getTypeId() {
        return 153;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public common.Fraction getOwnCreditPoints()throws ModelException{
        return this.ownCreditPoints;
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws ModelException {
        this.ownCreditPoints = newValue;
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomar(this);
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getCreditPointsIndex() throws ModelException {
        return 0 + 1;
    }
    public int getOwnCreditPointsIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "creditPoints";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "ownCreditPoints";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getCreditPoints();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getOwnCreditPoints();
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
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setOwnCreditPoints(common.Fraction.parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
