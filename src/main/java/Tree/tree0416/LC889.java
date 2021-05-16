package Tree.tree0416;
/*
 * @Description: 889. 根据前序和后序遍历构造二叉树
返回与给定的前序和后序遍历匹配的任何二叉树。

 pre 和 post 遍历中的值是不同的正整数。



示例：

输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]


提示：

1 <= pre.length == post.length <= 30
pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/16 18:44
 */
public class LC889 {
    int[] pre;
    int[] post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return dfs(0,0,post.length);

    }

    //preIndex: 前序遍历当前树的起始下标
    //postIndex: 后续遍历当前树范围内的起始下标
    //count: 当前树的结点个数
    public TreeNode dfs(int preIndex, int postIndex, int count){
        //空树
        if(count==0){
            return null;
        }
        //当前树的根结点一定是前序的第一个位置
        TreeNode root = new TreeNode(pre[preIndex]);
        //只有一个结点 返回当前根结点
        if(count==1){
            return root;
        }
        //L: 当前树左子树的结点个数
        int L = 1;
        for(; L<count; L++){
            //左子树的根结点是pre[preIndex+1], 前序遍历左子树的根结点一定在根结点后面一位
            //在后续遍历中找到当前树的左子树的根结点 一定是左子树范围内最后一个结点
            //后续遍历 [左子树] [右子树] [根结点]
            if(post[postIndex+L-1]==pre[preIndex+1]){
                break;
            }
        }
        //当前的左子树 前序遍历中从preIndex+1开始, 后续遍历中还是从postIndex开始, 数的数量是L
        root.left = dfs(preIndex+1, postIndex, L);
        //当前树的右子树, 前序遍历中从preIndex+1+L开始 后续遍历从postIndex+L开始
        // preIndex+L是左子树的最后一个结点的位置 因为 preIndex+L-(preIndex+1)+1 = L
        //数的数量为整个树(count)-左子树个数(L)-根结点(1)
        root.right = dfs(preIndex+L+1, postIndex+L, count-L-1);
        return root;
    }
}
