package fit;

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Dữ liệu XML ban đầu
        String xmlData = "<data>Hello XML</data>";

        // Chuyển XML sang JSON và xử lý
        JSONService jsonService = new JSONService();
        IFormatAdapter xmlToJsonAdapter = new XMLToJSONAdapter(jsonService);
        String jsonResponse = xmlToJsonAdapter.convert(xmlData);
        System.out.println("Converted JSON Response: " + jsonResponse);

        // Dữ liệu JSON ban đầu
        String jsonData = "{\"data\": \"Hello JSON\"}";

        // Chuyển JSON sang XML và xử lý
        XMLService xmlService = new XMLService();
        IFormatAdapter jsonToXmlAdapter = new JSONToXMLAdapter(xmlService);
        String xmlResponse = jsonToXmlAdapter.convert(jsonData);
        System.out.println("Converted XML Response: " + xmlResponse);
    }
}