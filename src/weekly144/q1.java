package weekly144;

import java.util.*;

public class q1 {
	public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        char[] c = address.toCharArray();
        for (int i=0; i<c.length; i++) {
        	if (c[i] == '.') {
        		sb.append("[.]");
        	}
        	else {
        		sb.append(c[i]);
        	}
        }
        return sb.toString();
    }
}
