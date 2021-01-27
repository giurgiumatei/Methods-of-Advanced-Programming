package Model.Statements;

import Model.ADTs.MyDictionary_Interface;
import Model.ProgramState.ProgramState;
import Model.Types.IntType;
import Model.Types.Type;
import Model.Values.IntValue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class New_LockStatement implements Statement{

    String variable;

    public New_LockStatement(String variable)
    {
        this.variable = variable;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception
    {
        Lock lock=new ReentrantLock();
        lock.lock();
        state.get_lock_table().put(state.get_lock_table().get_free_address(),-1);
        if(state.get_symbol_table().is_defined(this.variable))
        {
            Type variable_type=state.get_symbol_table().lookup(this.variable).get_type();
            if(variable_type.equals(new IntType()))
            {
                state.get_symbol_table().update(this.variable,new IntValue(state.get_lock_table().get_free_address()));
            }
            else
            {
                throw new Exception("Variable is not of type INT in the New Lock Statement!");
            }
        }
        else
        {
            throw new Exception("Variable is not defined in the Symbol Table!");
        }
        lock.unlock();

        return null;
    }

    @Override
    public MyDictionary_Interface<String, Type> type_check(MyDictionary_Interface<String, Type> type_environment) throws Exception
    {
        var variable_type=type_environment.lookup(variable);


        if(variable_type.equals(new IntType()) )
        {
            return type_environment;
        }
        else
        {
            throw new Exception("Variable not of type INT in the New Latch Statement!");
        }

    }

    @Override
    public String toString()
    {
        return "newLock(" + variable + ")";
    }
}
