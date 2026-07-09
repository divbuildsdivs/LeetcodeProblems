class TimeMap {
    HashMap<String , TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            TreeMap<Integer, String> treemap = new TreeMap();
                treemap.put(timestamp, value);
            map.put(key, treemap);
        }
        else {
            TreeMap<Integer, String> valMap = map.get(key);
            valMap.put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
         if(!map.containsKey(key)) {
            return "";
        }
        else {
            TreeMap<Integer, String> valMap = map.get(key);
            Map.Entry<Integer, String> entry = valMap.floorEntry(timestamp);

            return entry == null ? "" : entry.getValue();
        }
    }
}
