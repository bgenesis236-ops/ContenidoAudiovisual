package app.main;

import app.controller.ContentController;
import app.repository.CsvRepository;
import app.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        CsvRepository repo = new CsvRepository("contenidos.csv");
        ContentController controller = new ContentController(repo);
        ConsoleView view = new ConsoleView(controller);
        view.start();
    }
}
