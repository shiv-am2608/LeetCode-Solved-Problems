class Solution {
    public int solution(String words[],int freq[],int score[],int start)
    {
        if(start==words.length)
            return 0;
        int notIncluded=solution(words,freq,score,start+1);
        
        int currScore=0;
        boolean isPossible=true;
        String currWord=words[start];
        for(int i=0;i<currWord.length();i++)
        {
            int currLetter=currWord.charAt(i)-'a';
            if(freq[currLetter]<=0)
                isPossible=false;
            freq[currLetter]--;
            currScore+=score[currLetter];
        }
        int included=0;
        if(isPossible)
            included=currScore+solution(words,freq,score,start+1);
        for(int i=0;i<currWord.length();i++)
            freq[currWord.charAt(i)-'a']++;
        return Math.max(notIncluded,included);
            
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[]=new int[26];
        for(char ch:letters)
            freq[ch-'a']++;
        return solution(words,freq,score,0);
    }
}