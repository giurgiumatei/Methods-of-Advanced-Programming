package Controller;
import Model.Vehicle;
import Repository.*;

public interface Controller_Interface
{
    public void add(Vehicle vehicle) throws Exception;
    public void remove(Vehicle vehicle) throws Exception;
    public int get_length();
    public Vehicle[] get_vehicles();
    public Vehicle[] filter_vehicles();
}
