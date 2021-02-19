package Repository;

import Model.Vehicle;

public class Repository implements  Repository_Interface
{

    private Vehicle[] vehicles;
    private int length=0;

    public Repository()
  {
      vehicles=new Vehicle[50];
  }

    @Override
    public  boolean is_in_list(Vehicle vehicle)
    {
        for(int i=0;i<this.length;i++)
        {
            if (this.vehicles[i].get_name().equals(vehicle.get_name()) && this.vehicles[i].get_repair_cost() == vehicle.get_repair_cost())
            {

                return true;
            }
        }
        return  false;

    }

    @Override
    public void add(Vehicle vehicle)
    {
        vehicles[this.length]=vehicle;
        this.length++;

    }

    @Override
    public void remove(Vehicle vehicle)
    {
        for(int i=0;i<this.length;i++)
        {
            if(this.vehicles[i].get_name().equals(vehicle.get_name()) && this.vehicles[i].get_repair_cost() == vehicle.get_repair_cost())
            {

                for(int j=i;j<this.length-1;j++)
                {
                    this.vehicles[j]=this.vehicles[j+1];
                }
                this.length--;
                break;
            }
        }

    }

    @Override
    public Vehicle[] get_vehicles()
    {
        return this.vehicles;
    }
    @Override
    public int get_length()
    {
        return this.length;
    }
}
