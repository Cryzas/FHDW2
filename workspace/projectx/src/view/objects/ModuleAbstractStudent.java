
package view.objects;

import view.*;


/* Additional import section end */

public abstract class ModuleAbstractStudent extends ViewObject implements ModuleAbstractStudentView{
    
    protected ModuleAbstractSGroupView moduleCopy;
    protected String name;
    protected common.Fraction creditPoints;
    protected GradeView grade;
    protected common.Fraction CPmulGrade;
    protected common.Fraction CPwithGrade;
    
    public ModuleAbstractStudent(ModuleAbstractSGroupView moduleCopy,String name,common.Fraction creditPoints,GradeView grade,common.Fraction CPmulGrade,common.Fraction CPwithGrade,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.moduleCopy = moduleCopy;
        this.name = name;
        this.creditPoints = creditPoints;
        this.grade = grade;
        this.CPmulGrade = CPmulGrade;
        this.CPwithGrade = CPwithGrade;        
    }
    
    public ModuleAbstractSGroupView getModuleCopy()throws ModelException{
        return this.moduleCopy;
    }
    public void setModuleCopy(ModuleAbstractSGroupView newValue) throws ModelException {
        this.moduleCopy = newValue;
    }
    public String getName()throws ModelException{
        return this.name;
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return this.creditPoints;
    }
    public GradeView getGrade()throws ModelException{
        return this.grade;
    }
    public common.Fraction getCPmulGrade()throws ModelException{
        return this.CPmulGrade;
    }
    public common.Fraction getCPwithGrade()throws ModelException{
        return this.CPwithGrade;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ModuleAbstractSGroupView moduleCopy = this.getModuleCopy();
        if (moduleCopy != null) {
            ((ViewProxi)moduleCopy).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleCopy.getClassId(), moduleCopy.getId())));
        }
        GradeView grade = this.getGrade();
        if (grade != null) {
            ((ViewProxi)grade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(grade.getClassId(), grade.getId())));
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getCreditPointsIndex() throws ModelException {
        return 0 + 1;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
