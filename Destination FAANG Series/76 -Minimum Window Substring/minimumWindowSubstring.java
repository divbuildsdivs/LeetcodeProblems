class Solution {
    public String minWindow(String s, String t) {
        int left =0, right=0, formed = 0, uniqueChars;
        String res = "";

        System.out.println("Starting minWindow with s='" + s + "' and t='" + t + "'");

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i =0; i<t.length(); i++){
            addNewCharacter(tmap, t.charAt(i));
        }
        uniqueChars = tmap.size();
        System.out.println("Target frequency map: " + tmap);
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            System.out.println("Edge case: returning empty string.");
            return res;
        }
        else if(s.equals(t)) {
            System.out.println("Edge case: s equals t. Returning s.");
            return s;
        }
        else {
            System.out.println("Initializing sliding window.");
        }   
        addNewCharacter(smap, s.charAt(right));
        while(right < s.length()) {
        
            if(!matchMaps(smap, tmap)) {
                if (right < s.length()-1) {
                    right++;
                    System.out.println("Window is not valid. Moving right pointer to: " + right);
                    addNewCharacter(smap, s.charAt(right));
                    System.out.println("\nExpanding window: left=" + left + ", right=" + right + ", char='" + s.charAt(right) + "'");
                    System.out.println("Current window: '" + s.substring(left, right + 1) + "'");
                    System.out.println("Current source map after add: " + smap);
                }
                else {
                    System.out.println("Reached end of string. Cannot expand further.");
                    break;
                }
            }
            else if(matchMaps(smap, tmap)){
                System.out.println("Window is valid: [" + left + ", " + right + "] -> '" + s.substring(left, right + 1) + "'");
                if(res.equals("") || (right - left + 1) < res.length()){
                    res = s.substring(left, right + 1);
                    System.out.println("Updated best result to: '" + res + "'");
                }
                if(left < right){
                    System.out.println("Shrinking window by removing s[" + left + "]='" + s.charAt(left) + "'");
                    removeCharacter(smap, s.charAt(left));
                    left++;
                    System.out.println("Shrunk window: left=" + left + ", right=" + right + ". Current window: '" + s.substring(left, right + 1) + "'");
                    System.out.println("Current source map after remove: " + smap);
                }
                else {
                    right++;
                    System.out.println("Cannot be shrinked After Expanding: left=" + left + ", right=" + right + ". Moving right pointer.");
                }
            }
        }
        System.out.println("Finished. Final result='" + res + "'");
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
                System.out.println(
                    "Window invalid for char='" + entry.getKey() + "'. Needed=" + entry.getValue()
                    + ", found=" + smap.getOrDefault(entry.getKey(), 0)
                );
                return false;
            }
       }
       System.out.println("Window satisfies target requirements.");
       return true;
    }

}