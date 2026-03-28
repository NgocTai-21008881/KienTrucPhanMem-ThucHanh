/*
 * @ (#) JSONToXMLAdapter.java    1.0    22/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/03/2025
 * @version: 1.0
 */

public class JSONToXMLAdapter implements IFormatAdapter {
    private final XMLService xmlService;

    public JSONToXMLAdapter(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public String convert(String jsonData) {
        // Chuyển đổi JSON sang XML (giả lập)
        String xmlData = "<data>" + jsonData.replace("{\"data\": \"", "").replace("\"}", "") + "</data>";
        return xmlService.processXML(xmlData);
    }
}
