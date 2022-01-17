package base.variables;

import base.config.XmlFileParse;


public class Var {

    private Var() {

    }

    //İstenilen sayfada şu şekilde import edilerek kullanılabilir :
    // import variables.Var;
    // var.baseURL

    public static final String baseURL = XmlFileParse.xmlFileParse("baseURL", "var.xml");

    public static final String loginUrl = XmlFileParse.xmlFileParse("loginUrl", "var.xml");

    public static final String browser = XmlFileParse.xmlFileParse("browser", "var.xml");

    public static final String mail = XmlFileParse.xmlFileParse("mail", "var.xml");

    public static final String Password = XmlFileParse.xmlFileParse("password", "var.xml");

    public static final String InvalidMail = XmlFileParse.xmlFileParse("InvalidMail", "var.xml");

    public static final String EmptyMail = XmlFileParse.xmlFileParse("EmptyMail", "var.xml");

    public static final String More24DıgıtPassword = XmlFileParse.xmlFileParse("More24DıgıtPassword", "var.xml");

    public static final String EmptyPassword = XmlFileParse.xmlFileParse("EmptyPassword", "var.xml");

    public static final String databaseIp = XmlFileParse.xmlFileParse("databaseIp", "var.xml");

    public static final String connectionUrlBase = XmlFileParse.xmlFileParse("connectionUrlBase", "var.xml");

    public static final String databaseName = XmlFileParse.xmlFileParse("databaseName", "var.xml");

    public static final String dbUser = XmlFileParse.xmlFileParse("dbUser", "var.xml");

    public static final String dbPassword = XmlFileParse.xmlFileParse("dbPassword", "var.xml");






}