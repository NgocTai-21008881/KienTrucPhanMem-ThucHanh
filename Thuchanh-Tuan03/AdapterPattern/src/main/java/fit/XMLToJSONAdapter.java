/*
 * @ (#) XMLToJSONAdapter.java    1.0    22/03/2025
 * Copyright (c) 2025 IUH. All rights reserved.
 */
package fit;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/03/2025
 * @version: 1.0
 */

public class XMLToJSONAdapter implements IFormatAdapter {
    private final JSONService jsonService;

    public XMLToJSONAdapter(JSONService jsonService) {
        this.jsonService = jsonService;
    }

    @Override
    public String convert(String xmlData) {
        // Chuyển đổi XML sang JSON (giả lập)
        String jsonData = "{\"data\": \"" + xmlData.replace("<data>", "").replace("</data>", "") + "\"}";
        return jsonService.processJSON(jsonData);
    }
}
