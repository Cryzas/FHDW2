
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudyGroupManager extends ViewObject implements StudyGroupManagerView{
    
    protected java.util.Vector<StudyGroupView> groups;
    
    public StudyGroupManager(java.util.Vector<StudyGroupView> groups,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.groups = groups;        
    }
    
    static public long getTypeId() {
        return 186;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<StudyGroupView> getGroups()throws ModelException{
        return this.groups;
    }
    public void setGroups(java.util.Vector<StudyGroupView> newValue) throws ModelException {
        this.groups = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroupManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroupManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroupManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> groups = this.getGroups();
        if (groups != null) {
            ViewObject.resolveVectorProxies(groups, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getGroups().size()) return new GroupsStudyGroupManagerWrapper(this, originalIndex, (ViewRoot)this.getGroups().get(index));
        index = index - this.getGroups().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getGroups().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getGroups().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getGroupsIterator = this.getGroups().iterator();
        while(getGroupsIterator.hasNext()){
            if(getGroupsIterator.next().equals(child)) return result;
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
