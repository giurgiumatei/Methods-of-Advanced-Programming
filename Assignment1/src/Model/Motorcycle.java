package Model;

public class Motorcycle implements  Vehicle{

    private  int repair_cost;
    private String name;

    public  Motorcycle(String name,int repair_cost)

    {
        this.name=name;
        this.repair_cost=repair_cost;
    }

    @Override
    public String to_string() {
        return "Type:Motorcycle | Repair Cost: "+this.repair_cost+" ;";
    }

    @Override
    public int get_repair_cost() {
        return this.repair_cost;
    }
    @Override
    public String get_name(){return this.name;}
}
