class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (findWords(words[i], x)) {
                result.add(i);
            }
        }
        return result;
    }
     public static boolean findWords(String str, char x) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == x) {
                return true;
            }
        }
        return false;
    }
}
