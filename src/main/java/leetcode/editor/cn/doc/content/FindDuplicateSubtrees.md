<p>给你一棵二叉树的根节点 <code>root</code> ，返回所有 <strong>重复的子树 </strong>。</p>

<p>对于同一类的重复子树，你只需要返回其中任意 <strong>一棵 </strong>的根结点即可。</p>

<p>如果两棵树具有<strong> 相同的结构</strong> 和 <strong>相同的结点值 </strong>，则认为二者是 <strong>重复 </strong>的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e1.jpg" style="height: 236px; width: 300px;" /></p>

<pre>
<strong>输入：</strong>root = [1,2,3,4,null,2,4,null,null,4]
<strong>输出：</strong>[[2,4],[4]]</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e2.jpg" style="height: 125px; width: 200px;" /></p>

<pre>
<strong>输入：</strong>root = [2,1,1]
<strong>输出：</strong>[[1]]</pre>

<p><strong>示例 3：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2020/08/16/e33.jpg" style="height: 202px; width: 300px;" /></strong></p>

<pre>
<strong>输入：</strong>root = [2,2,2,3,null,3,null]
<strong>输出：</strong>[[2,3],[3]]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中的结点数在 <code>[1, 5000]</code> 范围内。</li> 
 <li><code>-200 &lt;= Node.val &lt;= 200</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 哈希表 | 二叉树</details><br>

<div>👍 697, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=find-duplicate-subtrees" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

比如说，你站在图中这个节点 2 上：

![](https://labuladong.github.io/pictures/二叉树3/4.png)

如果你想知道以自己为根的子树是不是重复的，是否应该被加入结果列表中，你需要知道什么信息？

**你需要知道以下两点**：

**1、以我为根的这棵二叉树（子树）长啥样**？

**2、以其他节点为根的子树都长啥样**？

这就叫知己知彼嘛，我得知道自己长啥样，还得知道别人长啥样，然后才能知道有没有人跟我重复，对不对？

我怎么知道自己以我为根的二叉树长啥样？前文 [序列化和反序列化二叉树](https://labuladong.github.io/article/fname.html?fname=二叉树的序列化) 其实写过了，二叉树的前序/中序/后序遍历结果可以描述二叉树的结构。

我咋知道其他子树长啥样？每个节点都把以自己为根的子树的样子存到一个外部的数据结构里即可，按照这个思路看代码就不难理解了。

这道题的事件复杂度还是比较容易分析的，二叉树有 N 个节点，遍历需要 O(N) 时间；遍历每个节点时需要序列化子树所有节点，所需时间粗略算作 O(N)，那么总的复杂度就是它俩相乘，即 O(N^2)。

**详细题解：[东哥带你刷二叉树（后序篇）](https://labuladong.github.io/article/fname.html?fname=二叉树系列3)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
    // 记录所有子树以及出现的次数
    unordered_map<string, int> memo;
    // 记录重复的子树根节点
    vector<TreeNode*> res;

public:
    /* 主函数 */
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        traverse(root);
        return res;
    }

    string traverse(TreeNode* root) {
        if (root == nullptr) {
            return "#";
        }

        string left = traverse(root->left);
        string right = traverse(root->right);

        string subTree = left + "," + right + "," + to_string(root->val);

        int freq = memo[subTree];
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.push_back(root);
        }
        // 给子树对应的出现次数加一
        memo[subTree] = freq + 1;
        return subTree;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        memo = {}
        res = []

        def traverse(root):
            if not root:
                return "#"

            left = traverse(root.left)
            right = traverse(root.right)

            subTree = left + "," + right + "," + str(root.val)

            freq = memo.get(subTree, 0)
            # 多次重复也只会被加入结果集一次
            if freq == 1:
                res.append(root)
            # 给子树对应的出现次数加一
            memo[subTree] = freq + 1
            return subTree

        traverse(root)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    /* 主函数 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import (
    "strconv"
)

// TreeNode Definition for a binary tree node.

// findDuplicateSubtrees 记录所有子树以及出现的次数
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
    memo := make(map[string]int)
    res := []*TreeNode{}

    traverse(root, memo, &res)

    return res
}

// traverse 深度优先遍历
func traverse(root *TreeNode, memo map[string]int, res *[]*TreeNode) string {
    if root == nil {
        return "#"
    }

    left := traverse(root.Left, memo, res)
    right := traverse(root.Right, memo, res)

    subTree := left + "," + right + "," + strconv.Itoa(root.Val)

    freq := memo[subTree]
    // 多次重复也只会被加入结果集一次
    if freq == 1 {
        *res = append(*res, root)
    }
    // 给子树对应的出现次数加一
    memo[subTree]++
    return subTree
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findDuplicateSubtrees = function(root) {
    // 记录所有子树以及出现的次数
    const memo = new Map();
    // 记录重复的子树根节点
    const res = [];

    /* 主函数 */
    const traverse = function(root) {
        if (root == null) {
            return "#";
        }

        const left = traverse(root.left);
        const right = traverse(root.right);

        const subTree = left + "," + right + "," + root.val;

        const freq = memo.get(subTree) || 0;
        // 多次重复也只会被加入结果集一次
        if (freq === 1) {
            res.push(root);
        }
        // 给子树对应的出现次数加一
        memo.set(subTree, freq + 1);
        return subTree;
    };

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_find-duplicate-subtrees" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-duplicate-subtrees"></div></div>
</details><hr /><br />

</details>
</div>

