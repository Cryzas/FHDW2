package view.objects;

import view.ModelException;
import view.ModuleAtomarStudentView;
import view.ModuleGroupStudentView;
import view.ModuleWithUnitsStudentView;
import view.visitor.ModuleAbstractStudentReturnVisitor;

/* Additional import section end */

public class ModulesProgramStudentWrapper extends AssociationInTreeWrapper {

	public ModulesProgramStudentWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
		String toBeAdded = "";
		try {
			ModuleAbstractStudent module = (ModuleAbstractStudent)getWrappedObject().getTheObject();
			toBeAdded = module.accept(new ModuleAbstractStudentReturnVisitor<String>() {

				@Override
				public String handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException {
					return " | Schema: " + ((ModuleAtomarSGroupProxi)moduleAtomarStudent.getModuleCopy()).getGradeSystem().toString();
				}

				@Override
				public String handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException {
					return "";
				}

				@Override
				public String handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent)
						throws ModelException {
					return "";
				}
			});
		} catch (ModelException e) {
			e.printStackTrace();
		}
    	return this.getWrappedObject().toString() + toBeAdded;
    }

    /*End of protected part that is not overridden by persistence generator*/

}
