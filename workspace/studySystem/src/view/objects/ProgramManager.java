
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ProgramManager extends ViewObject implements ProgramManagerView{
    
    protected java.util.Vector<ProgramView> programs;
    
    public ProgramManager(java.util.Vector<ProgramView> programs,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.programs = programs;        
    }
    
    static public long getTypeId() {
        return 148;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ProgramView> getPrograms()throws ModelException{
        return this.programs;
    }
    public void setPrograms(java.util.Vector<ProgramView> newValue) throws ModelException {
        this.programs = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProgramManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> programs = this.getPrograms();
        if (programs != null) {
            ViewObject.resolveVectorProxies(programs, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getPrograms().size()) return new ProgramsProgramManagerWrapper(this, originalIndex, (ViewRoot)this.getPrograms().get(index));
        index = index - this.getPrograms().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getPrograms().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getPrograms().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getProgramsIterator = this.getPrograms().iterator();
        while(getProgramsIterator.hasNext()){
            if(getProgramsIterator.next().equals(child)) return result;
            result = result + 1;
        }
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
