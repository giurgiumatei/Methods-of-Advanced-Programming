package Model;

public class Car implements  Vehicle
{

    private int repair_cost;
    private String name;

    public Car(String name,int repair_cost)

    {
        this.name=name;
        this.repair_cost=repair_cost;
    }

    @Override
    public String to_string() {
        return "Name:"+this.name+" | Type:Car | Repair Cost:"+this.repair_cost+" ;";
    }

    @Override
    public int get_repair_cost() {
        return this.repair_cost;
    }
    @Override
    public String get_name(){return this.name;}
}
