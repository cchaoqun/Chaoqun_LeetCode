package company.daily;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/15-14:07
 */

/**
 DLinkedNode 双向链表 代表使用的过的项目
 head tail
 HashMap<Integer, Node> O(1)获取到key对应的node
 size    当前链表中节点得数量
 capacity    当前的最大容量
 get
 通过map得到对应的node
 将这个node放到链表的头
 put
 如果这个点存在,
 修改这个点的值
 将这个点放到双向链表的头
 如果这个点不存在
 创建这个点
 check这个链表是否达到上限
 达到, 需要删除链表尾的结点
 放入双向链表头
 删除链表尾
 tail移除
 移到链表头
 删除这个结点
 插入到链表头
 插入到链表头
 */
public class LRU {
    //双向链表
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
    //缓存 存放 key <--> 双向链表对应结点
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    //当前双向链表的大小
    private int size;
    //双向链表的容量
    private int capacity;
    //双向链表的伪 头尾结
    DLinkedNode head, tail;
    //初始化
    public LRU(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    //获取key对应的值, 值存在结点中
    public int get(int key){
        DLinkedNode node = cache.get(key);
        //不存在
        if(node==null){
            return -1;
        }
        //将对应结点移动到双向链表的头部
        moveToHead(node);
        return node.value;
    }

    //将key value放入缓存
    public void put(int key, int value){
        //查看当前key对应的结点是否存在
        DLinkedNode node = cache.get(key);
        //不存在
        if(node==null){
            //创建对应的双向链表的结点
            DLinkedNode newNode = new DLinkedNode(key,value);
            //放入到map中
            cache.put(key, newNode);
            //放入双向链表的头 因为是最新使用的
            addToHead(newNode);
            //链表的容量+1
            size++;
            //如果超出容量 需要删除尾部的元素 即 最久未使用的元素
            if(size>capacity){
                //删除元素的结点
                DLinkedNode tail = removeTail();
                //根据对应的key 在hashMap中删除对应的entry
                cache.remove(tail.key);
                size--;
            }
        }else{
            //存在 修改node.value 覆盖
            node.value = value;
            //最新更新的结点移动到双向链表的头部
            moveToHead(node);
        }
    }

    //将node添加到双向链表的头部
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    //从双向链表中移除node
    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //将node移动到双向链表的头部
    private void moveToHead(DLinkedNode node){
        //等于先添加到头部 再删除原来位置的结点
        removeNode(node);
        addToHead(node);

    }
    //删除双向链表尾的结点
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

class LRUCache2{
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 先删除旧的位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        // 超出capacity，删除最久没用的,利用迭代器删除第一个
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

