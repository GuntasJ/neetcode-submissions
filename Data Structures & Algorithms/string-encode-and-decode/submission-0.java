class Solution {

    public String encode(List<String> strs) {
        var stringBuilder = new StringBuilder();
        for (var string : strs) {
            stringBuilder.append(string).append('ਖ਼');
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == 'ਖ਼') {
                    strings.add(str.substring(i, j));
                    i = j;
                    break;
                }
            }
        }
        return strings;
    }
}
