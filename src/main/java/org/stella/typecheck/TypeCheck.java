package org.stella.typecheck;

import org.syntax.stella.Absyn.*;
import org.stella.typecheck.VisitTypeCheck;

public class TypeCheck
{
    public static void typecheckProgram(Program program) throws Exception
    {
        VisitTypeCheck v = new VisitTypeCheck();
        VisitTypeCheck.Context ctx = new VisitTypeCheck.Context();
        program.accept(v.new ProgramVisitor<Type, VisitTypeCheck.Context>(), ctx);
    }
}
