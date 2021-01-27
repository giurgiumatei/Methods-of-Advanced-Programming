package Model.Statements;

import Model.ADTs.MyDictionary_Interface;
import Model.ProgramState.ProgramState;
import Model.Types.IntType;
import Model.Types.Type;
import Model.Values.IntValue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnlockStatement implements Statement
{

    String variable;


    public UnlockStatement(String variable)
    {
        this.variable = variable;
    }

    @Override
    public ProgramState execute(ProgramState state) throws Exception
    {
        Lock lock=new ReentrantLock();
        lock.lock();

        var symbol_table=state.get_symbol_table();
        var lock_table=state.get_lock_table();

        if(!symbol_table.is_defined(this.variable))
        {
            throw new Exception("Variable not declared in the Unlock Statement!");
        }
        if(symbol_table.lookup(this.variable).get_type().equals(new IntType()))
        {
            throw new Exception("Variable not of Integer Type in the Unlock Statement!");
        }

        int found_index=((IntValue)symbol_table.lookup(this.variable)).get_value();

        if(lock_table.lookup(found_index).equals(state.get_id()))
        {
            lock_table.put(found_index,-1);
        }

        lock.unlock();

        return null;


    }

    @Override
    public MyDictionary_Interface<String, Type> type_check(MyDictionary_Interface<String, Type> type_environment) throws Exception {
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
    public String toString() {
        return "unlock(" + variable + ")";
    }
}
