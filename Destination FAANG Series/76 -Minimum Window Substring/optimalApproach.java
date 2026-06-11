class Solution {
    public String minWindow(String s, String t) {
        int left =0, right=0, formed = 0, uniqueChars, required = t.length();
        String res = "";

        // System.out.println("Starting minWindow with s='" + s + "' and t='" + t + "'");

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i =0; i<t.length(); i++){
            addNewCharacter(tmap, t.charAt(i));
        }
        uniqueChars = tmap.size();
       // System.out.println("Target frequency map: " + tmap);
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            // System.out.println("Edge case: returning empty string.");
            return res;
        }
        else if(s.equals(t)) {
            // System.out.println("Edge case: s equals t. Returning s.");
            return s;
        }
        else {
           // System.out.println("Initializing sliding window.");
        }   
        while(right < s.length()) {
            // System.out.println(
            //     "Loop state -> left=" + left + ", right=" + right
            //     + ", formed=" + formed + ", required=" + required
            //     + ", window='" + s.substring(left, right + 1) + "'"
            //     + ", smap=" + smap + ", res='" + res + "'"
            // );
            addNewCharacter(smap, s.charAt(right));
            if(tmap.containsKey(s.charAt(right)) && tmap.get(s.charAt(right)) >= smap.get(s.charAt(right))){
                    formed++;
                }
            while(formed == required){
                // System.out.println(
                //     "Contracting -> left=" + left + ", right=" + right
                //     + ", formed=" + formed + ", required=" + required
                //     + ", window='" + s.substring(left, right + 1) + "'"
                //     + ", smap=" + smap + ", res='" + res + "'"
                // );
                if(res.length() == 0 || (right - left + 1) < res.length()){
                    res = s.substring(left, right + 1);
                }
                removeCharacter(smap, s.charAt(left));
                if(tmap.containsKey(s.charAt(left)) && tmap.get(s.charAt(left)) > smap.getOrDefault(s.charAt(left), 0)){
                    formed--;
                }
                left++;  
            }

           right++;
        }
       // System.out.println("Finished. Final result='" + res + "'");
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
                // System.out.println(
                //     "Window invalid for char='" + entry.getKey() + "'. Needed=" + entry.getValue()
                //     + ", found=" + smap.getOrDefault(entry.getKey(), 0)
                // );
                return false;
            }
       }
       // System.out.println("Window satisfies target requirements.");
       return true;
    }

}