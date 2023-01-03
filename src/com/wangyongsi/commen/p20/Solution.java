package com.wangyongsi.commen.p20;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
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
    }
}
