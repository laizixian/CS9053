package edu.nyu.cs9053.homework2;

import edu.nyu.cs9053.homework2.model.EngineLightAlert;
import edu.nyu.cs9053.homework2.model.DiagnosticTroubleCode;
import java.util.regex.Matcher;

/**
 * User: blangel
 *
 * @see {@literal https://www.json.org/}
 * @see {@literal https://en.wikipedia.org/wiki/JSON}
 */
public class JsonParser {

    /**
     * @param alert to serialize into {@literal JSON}
     * @implNote a null value should be an {@linkplain IllegalArgumentException}; i.e. {@code throw new IllegalArgumentException}
     * @return the serialized {@literal JSON} representation of {@code alert}
     */
    public static String toJson(EngineLightAlert alert) {
    	if (alert == null) {
    		throw new IllegalArgumentException();
    	}
    	StringBuilder serializedJSONSB = new StringBuilder();
    	final String vehicleId = alert.getVehicleId();
    	String cleanVechicleId = "";
    	if (vehicleId != null) {
    		cleanVechicleId = String.format("\"vehicleId\":\"%s\",", vehicleId.replaceAll("\"", Matcher.quoteReplacement("\\\"")));
    	}
    	final Long dateTime = alert.getDateTime();
    	final DiagnosticTroubleCode[] TroubleCodes = alert.getCodes();
    	serializedJSONSB.append("{");
    	serializedJSONSB.append(cleanVechicleId);
    	serializedJSONSB.append("\"dateTime\":");
    	serializedJSONSB.append(dateTime);
    	final int len = TroubleCodes == null ? 0 : TroubleCodes.length;
    	if (len != 0) {
    		serializedJSONSB.append(",\"codes\":[");
    		for (int i = 0; i < len; i++) {
    			if (TroubleCodes[i] != null) {
    				if (i != 0) {
    					serializedJSONSB.append(",");
    				}
    				String currCode = "{}";
    				if (TroubleCodes[i].getCode() != null) {
    					currCode = String.format("{\"code\":\"%s\"}", TroubleCodes[i].getCode());
    				}
    				serializedJSONSB.append(currCode);
    			}
    		}
    		serializedJSONSB.append("]");
    	}
    	serializedJSONSB.append("}");
        return serializedJSONSB.toString(); // TODO - implement
    }

}
