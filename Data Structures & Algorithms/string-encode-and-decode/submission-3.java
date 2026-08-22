class Solution {

    public String encode(List<String> strs) {
        // if (strs.isEmpty()) {
        //     return "";
        // }
        var stringBuilder = new StringBuilder();
        for (var string : strs) {
            stringBuilder.append(string.length())
                .append("a")
                .append(string);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        // if (str.equals("")) {
        //     return List.of();
        // }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                var character = str.charAt(j);
                if (character == 'a') {
                    int stringLength = Integer.parseInt(str.substring(i, j));
                    strings.add(str.substring(j + 1, j + 1 + stringLength));
                    i = j + stringLength;
                    break;
                }
            }
        }
        return strings;
    }
}
