package watch.movie.gn.creational.abstractfactory;

public class WoodTable implements Table{
    @Override
    public void create() {
        System.out.println("Create wood table");
    }
}
