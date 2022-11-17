import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            LaboratorioController controller = LaboratorioController.getInstances();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
