package leetcode.editor.cn.datastructure;

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

        public boolean search(String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) {
                    return false;
                }
                p = p.children[i];
            }
            return p.val;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null){
                    return false;
                }
                p = p.children[i];
            }
            return true;
        }

        public String shortestPrefixOf(String word) {
            TrieNode p = root;
            StringBuilder builder = new StringBuilder();
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.val){
                    return builder.toString();
                }

                if (p.children[i] == null){
                    return "";
                }
                builder.append(c);
                p = p.children[i];

            }
            return "";
        }

        // 通配符匹配
//        public boolean keysWithPattern(TrieNode node, String pattern, int index) {
//            if (node == null) return false;
//            if (index == key.length()) return node.val;
//            int i = key.charAt(index) - 'a';
//            // 如果是通配符，直接和 26 个字母匹配 (简单粗暴！！)
//            if (key.charAt(index) == '.') {
//                for (int j = 0; j < 26; j++) {
//                    if (search(node.children[j], key, index + 1)) return true;
//                }
//                return false;
//            } else {
//                return search(node.children[i], key, index + 1);
//            }
//        }

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