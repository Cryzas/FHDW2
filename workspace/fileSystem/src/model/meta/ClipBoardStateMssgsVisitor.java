package model.meta;

public interface ClipBoardStateMssgsVisitor extends ClipBoardStateDOWNMssgsVisitor, ClipBoardStateUPMssgsVisitor {}


interface ClipBoardStateDOWNMssgsVisitor extends FilledCBStateDOWNMssgsVisitor, EmptyCBStateDOWNMssgsVisitor {

    
}


interface ClipBoardStateUPMssgsVisitor  {

    
}
