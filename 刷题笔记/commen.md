#### [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)

解题思路：

​	利用栈，左括号入栈，右括号如果是对应的栈顶的元素，出栈，不是对应的括号直接返回 false，如果最后栈内还有元素，返回 false，没有元素返回 true

```java
/**
 * 结点类
 */
class Node {
    Character value;
    Node next;

    public Node(Character val, Node next) {
        this.value = val;
        this.next = next;
    }
}

/**
 * 创建一个完整的栈
 */
// 头结点不存储东西
Node head = new Node(null, null);
char[] chars = s.toCharArray();
// 遍历开始，并且检测是否有效
for (char aChar : chars) {
    if (aChar == '{' || aChar == '[' || aChar == '(') {
        // 入栈操作
        head.next = new Node(aChar, head.next);
    } else {
        // 出栈操作
        if (head.next == null) {
            return false;
        }
        Character firstValue = head.next.value;
        // 记录是否是对应的括号
        boolean flag = false;
        switch (aChar) {
            case '}':
                flag = firstValue.equals('{');
                break;
            case ']':
                flag = firstValue.equals('[');
                break;
            case ')':
                flag = firstValue.equals('(');
                break;
        }
        if (!flag) {
            return false;
        } else {
            // 是对应的括号就出栈
            Node first = head.next;
            head.next = first.next;
        }
    }
}
return head.next == null;
```

#### [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/)

给你单链表的头节点 `head` ，请你反转链表，并返回反转后的链表。

![img](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

利用递归反转链表