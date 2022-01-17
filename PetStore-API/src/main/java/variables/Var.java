package variables;

import config.XmlFileParse;

public class Var {

    private Var() {

    }
    public static final String apiUrl = XmlFileParse.xmlFileParse("apiURL", "var.xml");
}