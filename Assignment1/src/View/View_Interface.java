package View;
import Model.Vehicle;
import Controller.*;

public interface View_Interface
{

    public void print_menu();
    public void add_object() throws Exception;
    public void remove_object() throws Exception;
    public void print_filtered_list();
    public void add_options();
    public void run();
    public void remove_options();
    public void premade_list() throws Exception;


}
