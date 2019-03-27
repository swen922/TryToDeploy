package view;

import convert.ForConverting;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SomeWindowController {

    @FXML
    private Label label;

    @FXML
    private void initialize() {

        String result = "";
        ForConverting fc = null;

        try {
            File file = new File("/Users/swen/Downloads/777/test.xml");
            Path pathToFile = Paths.get("/Users/swen/Downloads/777/test.xml");

            if (!file.exists()) {
                try {
                    Files.createFile(pathToFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            ForConverting forConverting = new ForConverting("My Name", 15);

            JAXBContext context = JAXBContext.newInstance(ForConverting.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(forConverting, file);


            Unmarshaller unmarshaller = context.createUnmarshaller();
            fc = (ForConverting) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        result = fc.getSomString() + " | " + fc.getId();
        label.setText(result);

    }

}
