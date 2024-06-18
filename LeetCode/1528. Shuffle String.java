class Solution {
    public String restoreString(String s, int[] indices) {
        // String 배열을 생성하고 indices 인덱스값에 String 순서대로 split해서 넣어주기
        String[] strArray = new String[indices.length];
        ArrayList<String> strList = new ArrayList<>();
        for (String i : s.split("")) {
            strList.add(i);
        }
        for (int i = 0; i < indices.length; i++) {
            strArray[indices[i]] = strList.get(i);
        }

        String result = "";
        for (int i = 0; i < strArray.length; i++) {
            result += strArray[i];
        }
        return result;
    }
}
