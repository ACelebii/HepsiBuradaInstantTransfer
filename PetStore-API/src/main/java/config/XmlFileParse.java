package config;

import org.testng.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlFileParse {
    public static String xmlFileParse(String tagName, String xmlFilePath) {

        try {
            File inputFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            try {
                tagName = doc.getElementsByTagName(tagName).item(0).getTextContent();
            } catch (NullPointerException e) {
                LogUtil.logger.error(e);
                Assert.fail("There is no tags inside " + xmlFilePath + "with Tag name:" + tagName);
            }
        } catch (ParserConfigurationException e) {
            LogUtil.logger.error(e);
        } catch (SAXException e) {
            LogUtil.logger.error(e);
        } catch (IOException e) {
            LogUtil.logger.error(e);
        }
        return tagName;
    }
}
