class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<String> ();
        int i = 0;
        int last = -1;
        int lineLength = 0;
        int actualCharCount = 0;

        // Greedily keep adding words until the next word would overflow the line.
        while(i < words.length) {
            if((lineLength + words[i].length()) <= maxWidth) {
                lineLength = lineLength + words[i].length() + 1;
                actualCharCount = actualCharCount + words[i].length();
                i++;
            }
            else {
                // Fully justify the completed line from last + 1 through i - 1.
                result.add(buildLine(words, last, i-1, maxWidth, actualCharCount));
                lineLength = 0;
                actualCharCount = 0;
                last = i - 1;
            }
        }

        // The final line is left-justified.
        result.add(buildLastLine(words, last, i-1, maxWidth, lineLength));
        return result;
    }

    String buildLine(String[] words, int last, int current, int maxWidth, int actualCharCount) {
        StringBuilder line = new StringBuilder();
        int totalSpaces = maxWidth - actualCharCount;

        // A single-word line is padded at the end.
        if(current - last == 1) {
            line.append(words[current]);
            while(totalSpaces > 0) {
                line.append(" ");
                totalSpaces--;
            }
            return line.toString();
        }
        
        int spacesInBetween = totalSpaces/ (current - last - 1);
        int extraSpacesInBetween = totalSpaces % (current - last - 1);

        // Spread leftover spaces from left to right, giving earlier gaps one extra space.
        for(int i = last + 1; i < current ; i++ ){
            line.append(words[i]);
            for(int s = 0; s < spacesInBetween; s++ ) {
                line.append(" ");
            }
            if(extraSpacesInBetween > 0) {
                line.append(" ");
                extraSpacesInBetween--;
            }
        }
        line.append(words[current]);
        return line.toString();
    }
    String buildLastLine(String[] words, int last, int current, int maxWidth, int lineLength) {
        StringBuilder line = new StringBuilder();
        int spacesInEnd = maxWidth - (lineLength - 1) ;

        // Last line uses a single space between words and remaining spaces at the end.
        for(int i = last + 1; i < current ; i++ ){
            line.append(words[i]);
            line.append(" ");
        }
        line.append(words[current]);
        while(spacesInEnd > 0) {
            line.append(" ");
            spacesInEnd--;
        }
        return line.toString();
    }

}