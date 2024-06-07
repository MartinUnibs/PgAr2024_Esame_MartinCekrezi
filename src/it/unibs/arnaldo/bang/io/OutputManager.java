package it.unibs.arnaldo.rovineperdute.io;

import it.kibo.fp.lib.AnsiColors;
import it.unibs.arnaldo.bang.main.UserInteraction;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * This class writes the route for both
 * teams into "routes.xml". If an exception
 * arises it shows an explanation and the
 * program continues as if nothing has happened,
 * so the output won't be available to the user.
 */
public class OutputManager {

    private static final String FILE = "resources/routes.xml";
    private static final String INIT_ERROR = "Error in initializing the writer:\n";
    private static final String WRITING_ERROR = "Error while writing!\n";
    private static final String TONATIUH = "Tonatiuh";
    private static final String METZTLI = "Metztli";
    private static final String ROUTES = "routes";
    private static final String ROUTE = "route";
    private static final String CITY = "city";
/*
    public static void writeRoutes(Path tonatiuhPath, Path metztliPath) {
        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;
        try (FileOutputStream writer = new FileOutputStream(FILE)) {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(writer, "UTF-8");
            try {
                xmlw.writeStartDocument("UTF-8", "1.0");
                xmlw.writeCharacters("\n");
                xmlw.writeStartElement(ROUTES);
                xmlw.writeCharacters("\n");

                writeRoute(xmlw, tonatiuhPath);
                writeRoute(xmlw, metztliPath);

                xmlw.writeEndElement();
                xmlw.writeEndDocument();
                xmlw.flush();
                xmlw.close();
            } catch (XMLStreamException e) {
                UserInteraction.printColoredMessage(WRITING_ERROR, AnsiColors.RED);
            }
        } catch (XMLStreamException | IOException e) {
            UserInteraction.printColoredMessage(INIT_ERROR + e.getMessage(), AnsiColors.RED);
        }
    }

    private static void writeRoute(XMLStreamWriter xmlw, Path path) throws XMLStreamException {
        xmlw.writeCharacters("\t");
        xmlw.writeStartElement(ROUTE);
        xmlw.writeAttribute("team", path.getTeam() == Path.TONATIUH ? TONATIUH : METZTLI);
        xmlw.writeAttribute("cost", String.format("%.2f", path.getCost()));
        xmlw.writeAttribute("cities", String.valueOf(path.getCities().size()));
        for (City city : path.getCities()) {
            xmlw.writeCharacters("\n\t\t");
            xmlw.writeEmptyElement(CITY);
            xmlw.writeAttribute("id", String.valueOf(city.getId()));
            xmlw.writeAttribute("name", String.valueOf(city.getName()));
        }
        xmlw.writeCharacters("\n\t");
        xmlw.writeEndElement();
        xmlw.writeCharacters("\n");
    }
 */
}
