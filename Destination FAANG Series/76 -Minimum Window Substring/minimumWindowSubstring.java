class Solution {
    public String minWindow(String s, String t) {
        int left =0, right=0, formed = 0, uniqueChars;
        String res = "";

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i =0; i<t.length(); i++){
            addNewCharacter(tmap, t.charAt(i));
        }
        uniqueChars = tmap.size();
        while(right < s.length()) {
            addNewCharacter(smap, s.charAt(right));
            if(!matchMaps(smap, tmap)) {
                right++;
            }
            else if(matchMaps(smap, tmap)){
                if(res.equals("") || (right - left + 1) < res.length()){
                    res = s.substring(left, right + 1);
                }
                removeCharacter(smap, s.charAt(left));
                left++;
            }
        }
        return res;
    }

    void addNewCharacter(Map<Character, Integer> map, Character key){
        Integer val = map.getOrDefault(key, 0);
        if(val == 0){
            map.put(key, 1);     
        }
        else {
            map.replace(key, val + 1);
        }
    }
    void removeCharacter(Map<Character, Integer> map, Character key){
        if(map.getOrDefault(key, 0) > 1){
            map.replace(key, (map.get(key) - 1));
        }
        else {
            map.remove(key);
        }
    }

    boolean matchMaps(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
       for(Map.Entry<Character, Integer> entry: tmap.entrySet()) {
            if(!smap.containsKey(entry.getKey()) || smap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
       }
       return true;
    }

}