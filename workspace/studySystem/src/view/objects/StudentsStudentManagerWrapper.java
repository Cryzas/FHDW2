package view.objects;

/* Additional import section end */

public class StudentsStudentManagerWrapper extends AssociationInTreeWrapper {

	public StudentsStudentManagerWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
		String toBeAdded = "";
		try {
			toBeAdded = " | " + ((Student)this.getWrappedObject().getTheObject()).getParentGroup().iterator().next().getName();
		} catch (Exception e) {
		}
    	return this.getWrappedObject().toString() + toBeAdded;
    }

    /*End of protected part that is not overridden by persistence generator*/

}
