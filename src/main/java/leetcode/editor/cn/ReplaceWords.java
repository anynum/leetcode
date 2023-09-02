package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;

/**
 * 题目：单词替换
 * 题目编号：648
 * 时间：2023-09-03 20:58:48
 * 通过：？
 */
public class ReplaceWords {
    public static void main(String[] args) {
        Solution solution = new ReplaceWords().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie {

            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode p = root;
                for (char c : word.toCharArray()) {
                    int i = c - 'a';
                    if (p.children[i] == null) {
                        p.children[i] = new TrieNode();
                    }
                    p = p.children[i];
                }
                p.val = true;
            }

            public String shortestPrefixOf(String word) {
                TrieNode p = root;
                StringBuilder builder = new StringBuilder();
                for (char c : word.toCharArray()) {
                    int i = c - 'a';
                    if (p.val) {
                        return builder.toString();
                    }
                    if (p.children[i] == null) {
                        return null;
                    }
                    builder.append(c);
                    p = p.children[i];

                }
                return null;
            }

            class TrieNode {
                boolean val;
                TrieNode[] children;

                public TrieNode() {
                    children = new TrieNode[26];
                }

                public TrieNode(boolean _val) {
                    this.val = _val;
                    children = new TrieNode[26];
                }
            }
        }


        public String replaceWords(List<String> dictionary, String sentence) {
            Trie trie = new Trie();
            for (String s : dictionary) {
                trie.insert(s);
            }

            String[] segments = sentence.split(" ");
            for (int i = 0; i < segments.length; i++) {
                String s = trie.shortestPrefixOf(segments[i]);
                if (s != null) {
                    segments[i] = s;
                }
            }
            return String.join(" ", segments);
        }


        public String replaceWordsV1(List<String> dictionary, String sentence) {
            HashSet<String> set = new HashSet<>(dictionary);
            String[] segment = sentence.split(" ");
            for (int i = 0; i < segment.length; i++) {
                for (int k = 0; k < segment[i].length(); k++) {
                    String sub = segment[i].substring(0, i);
                    if (set.contains(sub)) {
                        segment[i] = sub;
                        break;
                    }
                }
            }

            return String.join(" ", segment);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词
//根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继
//承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 
//输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by 
//the battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 
//输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
//
// 
//
// Related Topics 字典树 数组 哈希表 字符串 👍 297 👎 0
