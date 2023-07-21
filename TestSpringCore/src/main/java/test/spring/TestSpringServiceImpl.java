package test.spring;

public class TestSpringServiceImpl implements TestSpringService {
    @Override
    public void printClassName() {
        System.out.println(this.getClass().getName());
    }
}
