class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<String> ();
        ArrayList<String> lineArray =new ArrayList<String> ();
        int lineLength = 0;
        int remainder = maxWidth;
        for(int i = 0; i < words.length; i++) {
            if((words[i].length()) <= remainder){
                lineArray.add(words[i] + " ");
                lineLength = lineLength + words[i].length() + 1;
                remainder = maxWidth - lineLength;
            }
            else {
                // Reprocess the current word after finalizing the previous line.
                i--;
                String lineStr = getPaddedString(lineArray, remainder, lineLength, false);
                result.add(lineStr);
                lineArray = new ArrayList<String> ();
                remainder = maxWidth;
                lineLength = 0;
            }
        }
        if(lineArray.size() > 0) {
            // The final line stays left-justified.
            result.add(getPaddedString(lineArray, remainder, lineLength, true));
         }
        return result;
    }

    String getPaddedString (ArrayList<String> lineArray, int remainder, int lineLength, boolean isLastLine) {
        int j = 0;
        if(lineArray.size() == 1 ||isLastLine) {
            lineArray.set(lineArray.size() - 1, lineArray.get(lineArray.size() - 1).trim());
            lineLength--;
            remainder++;
            // Remove the trailing word space before padding the line end.
            while(remainder > 0){
                lineArray.set(lineArray.size() - 1, lineArray.get(lineArray.size() - 1) + " ");
                lineLength++;
                remainder--;   
            }
        }
        else if(lineArray.size() > 1) {
            lineArray.set(lineArray.size() - 1, lineArray.get(lineArray.size() - 1).trim());
            lineLength--;
            remainder++;
            // Distribute extra spaces across gaps from left to right.
            while(remainder > 0) {
                lineArray.set(j, lineArray.get(j) + " ");
                j++;
                lineLength++;
                remainder--;
                if(j == (lineArray.size() - 1)) {
                    j = 0;
                }
            }
        }
        String lineStr = String.join("", lineArray);
        return lineStr;
    }
}