class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<String> ();
        ArrayList<String> line =new ArrayList<String> ();
        for(int i = 0; i < words.length; i++) {
            int remainder = maxWidth - line.length();
            if((words[i].length()) <= remainder){
                line.add(words[i] + " ");
            }
            else {
                int j = 0;
                while(remainder > 0) {
                    line[j].append(" ");
                    j++;
                    if(j == line.length) {
                        j = 0;
                    }
                }
            }


        }
    }
}