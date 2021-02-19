package Repository;
import Model.Vehicle;


public interface Repository_Interface
{
    public void add(Vehicle vehicle);
    public void remove(Vehicle vehicle);
    public int get_length();
    public Vehicle[] get_vehicles();
    public boolean is_in_list(Vehicle vehicle);



}
