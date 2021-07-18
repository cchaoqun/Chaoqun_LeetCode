package Algorithm_HW.Advanced.SegmentTree;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/18-17:28
 */

public class NumArray {
    /**
     * segment tree: 每个非叶子结点的num=left.num+right.num
     *                          start = left.start
     *                          end = right.end
     *                          left.end = (start+end)>>>1
     *                          right.start = (start+end)>>>1+1
     * 叶子结点 start = end
     *          num = nums[start]
     * 不是一个complete tree 是一个 full balanced tree
     *         complete tree 除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐
     *         full tree 除了叶子结点之外的每一个结点都有两个孩子结点
     *         balanced tree 左右子树的高度只差<=1
     * 叶子结点数量 = nums.length
     * 总结点的数量 = 2*n-1
     * update(index, val) 只会走一条路
     * sumRange(i, j) 最多走两条路
     */
    class TreeNode {
        int start;
        int end;
        int num;
        TreeNode left;
        TreeNode right;

        public TreeNode(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }
    }

    //保留原数组的值
    private int[] nums;
    private TreeNode root;

    public NumArray(int[] nums) {
        //deep copy
        this.nums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            this.nums[i] = nums[i];
        }
        // build tree
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    //build tree based on array nums in range [left, right]
    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(left, right, nums[left]);
        }
        int mid = (left + right) >>> 1;
        TreeNode leftNode = buildTree(nums, left, mid);
        TreeNode rightNode = buildTree(nums, mid + 1, right);
        TreeNode root = new TreeNode(left, right, leftNode.num + rightNode.num);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    private boolean checkRange(int index) {
        return 0 <= index && index < nums.length;
    }


    public void update(int index, int val) {
        //检查越界
        if (!checkRange(index)) {
            System.out.println("input index is out of raneg of nums");
            return;
        }
        //在根到index位置的路径上每个node都更新差量
        int diff = val - nums[index];
        //无需更改
        if (diff == 0) {
            return;
        }
        //先更新nums数组上对应index位置的值 但是树中 range=[index,index]的结点的num还没更新
        nums[index] = val;
        //更新路径上的结点
        update(root, index, diff);
    }

    private void update(TreeNode root, int pos, int diff) {
        if (root == null || pos < root.start || pos > root.end) {
            return;
        }
        //更新当前路径的结点值
        root.num += diff;
        update(root.left, pos, diff);
        update(root.right, pos, diff);
    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    //求出区间的[left, right]的和
    private int sumRange(TreeNode root, int left, int right) {
        if (left > right) {
            return 0;
        }
        //root区间刚好代表[left, right]
        if (root.start == left && root.end == right) {
            return root.num;
        }
        //root代表的区间的中点
        int mid = (root.start + root.end) >>> 1;
        /**
         root.start   mid     root.end
         [                       ]
         (    )
         left    right
                        (     )
                        left right
            (                  )
            left              right
         */
        //等于分割开的[left, Math.min(mid,right)] [Math.max(left, mid+1), right] 区间的和
        return sumRange(root.left, left, Math.min(mid, right)) + sumRange(root.right, Math.max(left, mid + 1), right);
    }
}
class NumArray_M2{
    //array based tree
    /**
     array based tree root.index = 1
     left = index*2
     right= index*2+1
     root.index = 0
     left = index*2+1
     right = index*2+2
     */
    int[] tree;
    int size;


    public NumArray_M2(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }

        //4*n保证可以包括所有可能的结点数量
        this.size = nums.length;
        this.tree = new int[size<<2];

        buildTree(1, 0, size-1, nums);
    }
    //build tree based on array nums in range [start, end] for tree[]
    //return the range sum of [start, end]
    private int buildTree(int root, int start, int end, int[] nums){
        //叶子结点
        if(start==end){
            tree[root] = nums[start];
            return tree[root];
        }
        //当前结点的区间中点
        int mid = (start+end)>>>1;
        //左区间的sum
        int left = buildTree(root<<1, start, mid, nums);
        //右区间的sum
        int right = buildTree((root<<1)+1, mid+1, end, nums);
        //当前区间的sum=left+right
        tree[root] = left+right;
        //返回当前区间的sum
        return tree[root];
    }

    private boolean checkRange(int index){
        return 0<=index && index<size;
    }

    public void update(int index, int val) {
        //检查越界
        if (!checkRange(index)) {
            System.out.println("input index is out of raneg of nums");
            return;
        }

        update(1, 0, size-1, index, val);
    }
    //更新以root下标为根的树中 区间范围在 start end中 的index位置的路径上的结点的值+diff
    private int update(int root, int start, int end, int index, int val){
        if(start==end){
            int diff =  val-tree[root];
            tree[root] = val;
            return diff;
        }
        int mid = (start+end)>>>1;
        int diff = index<=mid?
                update(root<<1, start, mid, index, val):
                update((root<<1)+1, mid+1, end, index, val);
        tree[root] += diff;
        return diff;

    }



    public int sumRange(int left, int right) {
        return sumRange(1,0,size-1, left, right);
    }

    private int sumRange(int root,int start, int end,  int left, int right){
        if(left>right){
            return 0;
        }
        //叶子结点
        if(start==left && end==right){
            return tree[root];
        }
        //root结点代表区间的中点
        int mid = (start+end)>>>1;
        return sumRange(root<<1, start, mid, left, Math.min(right, mid))
                +sumRange( (root<<1)+1, mid+1, end, Math.max(left,mid+1), right);

    }

}
