
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ProgramStudent extends ViewObject implements ProgramStudentView{
    
    protected java.util.Vector<ModuleAbstractStudentView> modules;
    protected String name;
    protected common.Fraction creditPoints;
    protected ProgramSGroupView programCopy;
    protected GradeView grade;
    protected MyBooleanView finished;
    protected common.Fraction passedCP;
    
    public ProgramStudent(java.util.Vector<ModuleAbstractStudentView> modules,String name,common.Fraction creditPoints,ProgramSGroupView programCopy,GradeView grade,MyBooleanView finished,common.Fraction passedCP,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.modules = modules;
        this.name = name;
        this.creditPoints = creditPoints;
        this.programCopy = programCopy;
        this.grade = grade;
        this.finished = finished;
        this.passedCP = passedCP;        
    }
    
    static public long getTypeId() {
        return 192;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ModuleAbstractStudentView> getModules()throws ModelException{
        return this.modules;
    }
    public void setModules(java.util.Vector<ModuleAbstractStudentView> newValue) throws ModelException {
        this.modules = newValue;
    }
    public String getName()throws ModelException{
        return this.name;
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return this.creditPoints;
    }
    public ProgramSGroupView getProgramCopy()throws ModelException{
        return this.programCopy;
    }
    public void setProgramCopy(ProgramSGroupView newValue) throws ModelException {
        this.programCopy = newValue;
    }
    public GradeView getGrade()throws ModelException{
        return this.grade;
    }
    public MyBooleanView getFinished()throws ModelException{
        return this.finished;
    }
    public common.Fraction getPassedCP()throws ModelException{
        return this.passedCP;
    }
    
    public void accept(ProgramStudentVisitor visitor) throws ModelException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(ProgramStudentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends view.UserException>  void accept(ProgramStudentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends view.UserException> R accept(ProgramStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProgramStudent(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> modules = this.getModules();
        if (modules != null) {
            ViewObject.resolveVectorProxies(modules, resultTable);
        }
        ProgramSGroupView programCopy = this.getProgramCopy();
        if (programCopy != null) {
            ((ViewProxi)programCopy).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(programCopy.getClassId(), programCopy.getId())));
        }
        GradeView grade = this.getGrade();
        if (grade != null) {
            ((ViewProxi)grade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(grade.getClassId(), grade.getId())));
        }
        MyBooleanView finished = this.getFinished();
        if (finished != null) {
            ((ViewProxi)finished).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(finished.getClassId(), finished.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesProgramStudentWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
        index = index - this.getModules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModules().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getModules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModulesIterator = this.getModules().iterator();
        while(getModulesIterator.hasNext()){
            if(getModulesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0 + this.getModules().size();
    }
    public int getCreditPointsIndex() throws ModelException {
        return 0 + this.getModules().size() + 1;
    }
    public int getRowCount(){
        return 0 
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
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getCreditPoints();
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
        rowIndex = rowIndex - 1;
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
