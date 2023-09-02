package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：删除子文件夹
 * 题目编号：1233
 * 时间：2023-09-03 22:35:07
 * 通过：？
 */
public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        Solution solution = new RemoveSubFoldersFromTheFilesystem().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Trie trie = new Trie(false); // 构建一个字典树
            // 将所有的文件夹路径添加到字典树中
            for (String f : folder) {
                trie.add(f);
            }
            // 获取所有的根路径 返回结果
            List<String> res = new ArrayList<>();
            trie.getRootDirs(res, "");
            return res;
        }

        class Trie {
            Map<String, Trie> subDir;   // 子路径哈希表，键记录的是当前一级的文件夹名，值记录是子文件夹对应的字典树对象
            boolean isEnd;  // 标识位，标识是否为最后一级子文件夹

            public Trie(boolean isEnd) {
                subDir = new HashMap<>();
                this.isEnd = isEnd;
            }

            /**
             * 添加一个文件夹路径到字典树中
             */
            public void add(String dir) {
                String[] segments = dir.split("/");
                Trie trie = this;
                for (int i = 1; i < segments.length - 1; i++) {
                    String d = segments[i];
                    if (!trie.subDir.containsKey(d)) {
                        trie.subDir.put(d, new Trie(false));
                    }
                    trie = trie.subDir.get(d);
                }
                trie.subDir.put(segments[segments.length - 1], new Trie(true));
            }

            /**
             * 获取所有要保留下来的文件夹路径，即所有的根路径
             * res用于存储找到的根路径
             * folder用于拼接每一集文件夹名，最终得到完整的文件夹路径
             */
            public void getRootDirs(List<String> res, String foldder) {

                if (this.isEnd) {
                    res.add(foldder);
                    return;
                }

                for (Map.Entry<String, Trie> entry : this.subDir.entrySet()) {
                    entry.getValue().getRootDirs(res, foldder + "/" + entry.getKey());
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。 
//
// 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。 
//
// 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。 
//
// 
// 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//输出：["/a","/c/d","/c/f"]
//解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
// 
//
// 示例 2： 
//
// 
//输入：folder = ["/a","/a/b/c","/a/b/d"]
//输出：["/a"]
//解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
// 
//
// 示例 3： 
//
// 
//输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//输出: ["/a/b/c","/a/b/ca","/a/b/d"] 
//
// 
//
// 提示： 
//
// 
// 1 <= folder.length <= 4 * 10⁴ 
// 2 <= folder[i].length <= 100 
// folder[i] 只包含小写字母和 '/' 
// folder[i] 总是以字符 '/' 起始 
// folder 每个元素都是 唯一 的 
// 
//
// Related Topics 深度优先搜索 字典树 数组 字符串 👍 160 👎 0
