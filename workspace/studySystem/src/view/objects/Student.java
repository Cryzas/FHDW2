
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Student extends ViewObject implements StudentView{
    
    protected String firstName;
    protected String lastName;
    protected java.util.Date birthDate;
    protected long matrNr;
    protected ProgramStudentView program;
    protected java.util.Vector<ProgramStudentView> oldPrograms;
    protected java.util.Vector<StudyGroupView> parentGroup;
    
    public Student(String firstName,String lastName,java.util.Date birthDate,long matrNr,ProgramStudentView program,java.util.Vector<ProgramStudentView> oldPrograms,java.util.Vector<StudyGroupView> parentGroup,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.matrNr = matrNr;
        this.program = program;
        this.oldPrograms = oldPrograms;
        this.parentGroup = parentGroup;        
    }
    
    static public long getTypeId() {
        return 195;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getFirstName()throws ModelException{
        return this.firstName;
    }
    public void setFirstName(String newValue) throws ModelException {
        this.firstName = newValue;
    }
    public String getLastName()throws ModelException{
        return this.lastName;
    }
    public void setLastName(String newValue) throws ModelException {
        this.lastName = newValue;
    }
    public java.util.Date getBirthDate()throws ModelException{
        return this.birthDate;
    }
    public void setBirthDate(java.util.Date newValue) throws ModelException {
        this.birthDate = newValue;
    }
    public long getMatrNr()throws ModelException{
        return this.matrNr;
    }
    public ProgramStudentView getProgram()throws ModelException{
        return this.program;
    }
    public void setProgram(ProgramStudentView newValue) throws ModelException {
        this.program = newValue;
    }
    public java.util.Vector<ProgramStudentView> getOldPrograms()throws ModelException{
        return this.oldPrograms;
    }
    public void setOldPrograms(java.util.Vector<ProgramStudentView> newValue) throws ModelException {
        this.oldPrograms = newValue;
    }
    public java.util.Vector<StudyGroupView> getParentGroup()throws ModelException{
        return this.parentGroup;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudent(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ProgramStudentView program = this.getProgram();
        if (program != null) {
            ((ViewProxi)program).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(program.getClassId(), program.getId())));
        }
        java.util.Vector<?> oldPrograms = this.getOldPrograms();
        if (oldPrograms != null) {
            ViewObject.resolveVectorProxies(oldPrograms, resultTable);
        }
        java.util.Vector<?> parentGroup = this.getParentGroup();
        if (parentGroup != null) {
            ViewObject.resolveVectorProxies(parentGroup, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProgram() != null) return new ProgramStudentWrapper(this, originalIndex, (ViewRoot)this.getProgram());
        if(this.getProgram() != null) index = index - 1;
        if(index < this.getOldPrograms().size()) return new OldProgramsStudentWrapper(this, originalIndex, (ViewRoot)this.getOldPrograms().get(index));
        index = index - this.getOldPrograms().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProgram() == null ? 0 : 1)
            + (this.getOldPrograms().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProgram() == null ? true : false)
            && (this.getOldPrograms().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProgram() != null && this.getProgram().equals(child)) return result;
        if(this.getProgram() != null) result = result + 1;
        java.util.Iterator<?> getOldProgramsIterator = this.getOldPrograms().iterator();
        while(getOldProgramsIterator.hasNext()){
            if(getOldProgramsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getFirstNameIndex() throws ModelException {
        return 0;
    }
    public int getLastNameIndex() throws ModelException {
        return 0 + 1;
    }
    public int getBirthDateIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getMatrNrIndex() throws ModelException {
        return 0 + 1 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "firstName";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "lastName";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "birthDate";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "matrNr";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getFirstName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getLastName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return ViewRoot.toString(getBirthDate(), false );
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getMatrNr());
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
            this.setFirstName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setLastName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setBirthDate(new java.text.SimpleDateFormat(DATEFORMAT).parse(newValue));
            return;
        }
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
