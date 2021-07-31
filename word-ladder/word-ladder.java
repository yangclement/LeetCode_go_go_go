class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //这是BFS的题目，就是看看如果最短路径到达目标的单词
        //每一种可能的变换都是一条path，例如"hit"->"hot"->"dot"
        //先用map存每个单词为一个key，然后value是一个set，代表可以从当前key改变一个字母所变成的在list里面的string，例如，dot:<lot, hot, dog>
        if (beginWord.equals(endWord)) {
            return 1;
        }
        //把所有的String放进set里面，防止duplicate，也方便查找
        Set<String> allWords = new HashSet<>();
        for (String word : wordList) {
            allWords.add(word);
        }
        
        Queue<String> queue = new ArrayDeque<String>();
        Set<String> visited = new HashSet<>();
        //需要把beginword放进visited里面，防止走回头路
        visited.add(beginWord);
        queue.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            //这里的每个for loop是一层，看看要多少层走到就是路径长度了
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //把当前第一位string拿出来
                String curr = queue.poll();
                //用当前的string去找在list中所有可能通过修改一个得到的所有string
                for (String next : getNextWords(curr, allWords)) {
                    if (visited.contains(next)) {
                        //已经走过了，不走回头路是BFS的要求
                        continue;
                    }
                    
                    //这里看看是不是已经走到了
                    if (next.equals(endWord)) {
                        return length;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
            
        }
        //出来都没找到，return 0
        return 0;
    }
    
    private String replace(String word, char i, int j) {
        //先把String变成char array，再把char array变成String
        char[] temp = word.toCharArray();
        temp[j] = i;
        return new String(temp);
    }
    
    private List<String> getNextWords(String word, Set<String> allWords) {
        List<String> results = new ArrayList<>();
        //对于这个word，把他每个位置的字母都换成a-z, 并且看看在不在allWords里面
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < word.length(); j++) {
                //replace function is used to replace a char i at index j
                String next = replace(word, i, j);
                if (allWords.contains(next)) {
                    results.add(next);
                }
            }
        }
        
        return results;
    }
}