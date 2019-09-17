package edu.nyu.cs9053.homework2;

import edu.nyu.cs9053.homework2.model.DiagnosticTroubleCode;
import java.util.Arrays;


/**
 * User: blangel
 */
public class Mechanic {

    /**
     * @see {@literal https://en.wikipedia.org/wiki/OBD-II_PIDs#Mode_3_(no_PID_required)}
     * @implNote For simplification of this homework, contrary to the Wikipedia article {@code data} is not in the ISO 15765-2 protocol.
     *           It is simply an array of data where the length should be equal to {@code expectedAmount} times 2.
     * @implNote If {code data} is null, empty or not equal to {@code expectedAmount} times 2 then throw
     *           an {@linkplain IllegalArgumentException}; i.e. {@code throw new IllegalArgumentException}
     * @param data to parse
     * @param expectedAmount of {@linkplain DiagnosticTroubleCode} to decode
     * @return the decoded {@linkplain DiagnosticTroubleCode} objects see {@linkplain DiagnosticTroubleCode#construct(String)} to create the object.
     */
    public static DiagnosticTroubleCode[] decode(byte[] data, int expectedAmount) {
        if (data == null || data.length != 2L * expectedAmount) {
            throw new IllegalArgumentException();
        }
        DiagnosticTroubleCode[] TroubleCodes = new DiagnosticTroubleCode[expectedAmount];
        for (int i = 0; i < expectedAmount; i++) {
            StringBuilder currCode = new StringBuilder();
            switch ((data[i * 2] >>> 6) & 0x03) {
                case 0:
                    currCode.append("P");
                    break;
                case 1:
                    currCode.append("C");
                    break;
                case 2:
                    currCode.append("B");
                    break;
                case 3:
                    currCode.append("U");
                    break;
            }
            currCode.append((data[i * 2] >>> 4 & 0b0011));
            currCode.append(Integer.toString(data[i * 2] & 0x0F, 16));
            currCode.append(Integer.toString(data[i * 2 + 1] >>> 4, 16));
            currCode.append(Integer.toString(data[i * 2 + 1] & 0x0F, 16));
            TroubleCodes[i] = DiagnosticTroubleCode.construct(currCode.toString());
        }
        return TroubleCodes; // TODO - implement
    }

}
