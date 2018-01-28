package com.jack.leetcode.test;

public class WinTshirt {
	
	public static String charArrayToString(char[] param) throws Exception {
		StringBuffer s = new StringBuffer();
		String result = "";
		if(param!=null&&param.length>0){
			s.append("\"");
			for(int i = 0; i < param.length; i++){
				String str = String.valueOf(param[i]);
				if(str.equals("\t")) str = str.replace("\t", "\\t");
				if(str.equals("\n")) str = str.replace("\n", "\\n");
				if(str.equals("\\")) str = str.replace("\\", "\\\\");
				if(str.equals("\"")) str = str.replace("\"", "\\\"");
				s.append(str+"\",\"");
			}
			result = s.toString();
			result = result.substring(0,result.length()-2);
		}
		result = "[" + result + "]";
		return result;
    }

    // Bonus point if your deserializer is able to deal with whitespaces between elements.
    // For example: param = "[  \"a\",  \"b\", \"c\"  ]"
    public static char[] stringToCharArray(String param) throws Exception {
        param = param.substring(1,param.length()-1);
        if(param==null||"".equals(param))
        	return null;
        param = param.substring(1,param.length()-1);
        param = param.replace("\",\"", "");
        param = param.replace("\\n","\n").replace("\\t", "\t")
        		.replace("\\\\", "\\").replace("\\\"", "\"");
        return param.toCharArray();
    }

    // Note: These tests are basic and passing them does not mean your code is correct.
    // Feel free to write additional tests and test serializer and deserializer individually.
    public static void main(String[] args) {
    	
        String[] testcases = {
            "[]",
            "[\"a\",\"b\",\"c\"]",
            "[\"T\",\"e\",\"!\",\"'\"]",
            "[\"'\",\"\\\"\",\"c\"]",
            "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]"
        };

        for(String testcase : testcases) {
            try {
                if (!charArrayToString(stringToCharArray(testcase)).equals(testcase)) {
                    System.out.println("TESTCASE FAILED : {}" + testcase);
                } else {
                    System.out.println("TESTCASE PASSED");
                }
            } catch(Exception e) {
                System.out.println("Exception occured in testcase : " + testcase);
                break;
            }
        }
    }
}
