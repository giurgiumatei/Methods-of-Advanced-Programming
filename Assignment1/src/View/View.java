package View;

import Controller.*;
import Model.*;
import java.util.Scanner;

public class View implements View_Interface
{
    Controller controller = new Controller();
    Scanner scanner=new Scanner(System.in);

    @Override
    public void print_menu()
    {
        System.out.println("Press:");
        System.out.println("1. Add; ");
        System.out.println("2. Remove; ");
        System.out.println("3. Print  all vehicles with a repair cost > 1000;");
        System.out.println("0. Exit. ");

    }
    @Override
    public void add_options()
    {
        System.out.println("1. Add a car;");
        System.out.println("2. Add a motorcycle;");
        System.out.println("3. Add a truck");

    }
    @Override
    public void remove_options()
    {
        System.out.println("1. Remove a car;");
        System.out.println("2. Remove a motorcycle;");
        System.out.println("3. Remove a truck");
    }

    @Override
    public void add_object() throws Exception
    {
        this.add_options();

        int option=Integer.parseInt(this.scanner.nextLine());
        System.out.println("Give the name of the vehicle to be added: ");
        String name=this.scanner.nextLine();
        System.out.println("Give the repair cost of the vehicle to be added: ");
        int repair_cost= Integer.parseInt(this.scanner.nextLine());

        if(option==1)
        {
            this.controller.add(new Car(name,repair_cost));
        }
        else if(option==2)
        {
            this.controller.add(new Motorcycle(name,repair_cost));
        }
        else if(option==3)
        {
            this.controller.add(new Truck(name,repair_cost));
        }



    }

    @Override
    public void remove_object() throws Exception
    {
        this.remove_options();

        int option=Integer.parseInt(this.scanner.nextLine());
        System.out.println("Give the name of the vehicle to be deleted: ");
        String name=this.scanner.nextLine();
        System.out.println("Give the repair cost of the vehicle to be deleted: ");
        int repair_cost= Integer.parseInt(this.scanner.nextLine());
        if(option==1)
        {
            this.controller.remove(new Car(name,repair_cost));
        }
        else if(option==2)
        {
            this.controller.remove(new Motorcycle(name,repair_cost));
        }
        else if(option==3)
        {
            this.controller.remove(new Truck(name,repair_cost));
        }


    }

    @Override
    public void print_filtered_list()
    {
        Vehicle[] vehicles=this.controller.filter_vehicles();

        for(int i=0;i< vehicles.length;i++)
        {
            if(vehicles[i]!=null)
            {
                System.out.println(vehicles[i]);
            }
        }

    }

    @Override
    public void premade_list() throws Exception
    {
        this.controller.add(new Car("Audi",1001));
        this.controller.add(new Motorcycle("Kawasaki",500));
        this.controller.add(new Truck("Volvo",30000));
    }

    @Override
    public void run()
    {

        while(true)
        {
            this.print_menu();
            int option;

            try{
                option=Integer.parseInt(this.scanner.nextLine());
            }catch(NumberFormatException exception)
            {
                continue;
            }

            if(option==1)
            {
                try{
                    this.add_object();
                }catch (Exception exception)
                {
                    System.out.print(exception.getMessage());
                }
            }
            else if(option==2)
            {
                try{
                    this.remove_object();
                }catch (Exception exception)
                {
                    System.out.print(exception.getMessage());
                }
            }
            else if(option==3)
            {
                this.print_filtered_list();
            }
            else if(option==0)
            {
                break;
            }
            else
            {
                System.out.println(("Invalid Command!"));
            }

        }

    }
}
