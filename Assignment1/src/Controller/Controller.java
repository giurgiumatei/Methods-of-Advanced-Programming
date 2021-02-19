package Controller;
import  Model.*;
import  Repository.*;

public class Controller implements Controller_Interface
{
    private Repository_Interface repository=new Repository();

    @Override
    public void add(Vehicle vehicle) throws Exception
    {
        if(this.repository.is_in_list(vehicle))
        {
            throw new Exception("Vehicle already in the list! ");
        }
       this.repository.add(vehicle);
    }

    @Override
    public void remove(Vehicle vehicle) throws Exception
    {
        if(!this.repository.is_in_list(vehicle))
        {
            throw new Exception("Vehicle not in the list! ");
        }
        this.repository.remove(vehicle);
    }

    @Override
    public int get_length()
    {
        return repository.get_length();
    }

    @Override
    public Vehicle[] get_vehicles()
    {
        return repository.get_vehicles();
    }

    @Override
    public Vehicle[] filter_vehicles()
    {
        Vehicle[] vehicles_list=this.filter_vehicles();
        Vehicle[] filtered_list=new Vehicle[50];
        int length_of_filtered_list=0;
        for(int i=0;i<this.repository.get_length();i++)
        {
            if(vehicles_list[i].get_repair_cost()>1000)
            {
                filtered_list[length_of_filtered_list]=vehicles_list[i];
                length_of_filtered_list++;
            }
        }

        return filtered_list;

    }
}
