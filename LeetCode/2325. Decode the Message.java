class Solution {
    public String decodeMessage(String key, String message) {
        // 기존의 알파벳 리스트로 저장
        List<String> originList = new ArrayList<>(
            List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", 
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

        // key 리스트로 저장 및 중복 제거
        Set<String> keySet = new LinkedHashSet<>();
        for (String s : key.split("")) {
            if (!s.equals(" ")) {
                keySet.add(s);
            }
        }
        List<String> keyList = new ArrayList<>(keySet);

        // 해독할 메시지 리스트로 저장
        List<String> messageList = new ArrayList<>();
        for (String s : message.split("")) {
            messageList.add(s);
        }

        StringBuilder answer = new StringBuilder();
        // message에 있는 내용을 매핑된 key의 알파벳으로 해독
        for (int i = 0; i < messageList.size(); i++) {
            if (messageList.get(i).equals(" ")) {
                answer.append(" ");
                continue;
            }
            for (int j = 0; j < keyList.size(); j++) {
                if (messageList.get(i).equals(keyList.get(j))) {
                    answer.append(originList.get(j));
                }
            }
        }
        // key의 알파벳으로 해독한 내용 리턴
        return answer.toString();
    }
}
