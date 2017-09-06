package view.objects;

import view.*;
import viewClient.*;

public abstract class GradesInSimpleProxi extends GradesInSimpleOrThirdProxi implements GradesInSimpleView{
    
    public GradesInSimpleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
