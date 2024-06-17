class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int findIndex = -1;
        int result = 0;
        if (ruleKey.equals("type")) {
            findIndex = 0;
        } else if (ruleKey.equals("color")) {
            findIndex = 1;
        } else {
            findIndex = 2;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(findIndex).equals(ruleValue)) {
                    result++;
                }
        }
        return result;
    }
}
