package my.training.basic;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

/**
 * 기본 자료구조와 알고리즘 구현
 * 이 클래스는 배열, 문자열, 연결 리스트, 스택, 큐, 해시 테이블을 포함한 기본 자료구조와 알고리즘 문제의 구현을 다룹니다.
 */
public class BasicDataStructures {

    /**
     * 배열과 문자열 - 회문 확인
     *
     * @param inputString 입력 문자열
     * @return 주어진 문자열이 회문인지 여부
     */
    public boolean isPalindrome(String inputString) {

        int left = 0;
        int right = inputString.length() - 1;

        while (left < right) {
            // 양쪽 끝의 문자가 다르면 회문이 아님
            if (inputString.charAt(left) != inputString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true; // 회문일 경우 true 반환
    }

    /**
     * 단일 연결 리스트 반전
     *
     * @param head 연결 리스트의 첫 번째 노드
     * @return 반전된 연결 리스트의 새로운 헤드
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null; // 이전 노드를 추적하는 포인터
        ListNode current = head; // 현재 노드를 추적하는 포인터

        while (current != null) {
            ListNode next = current.next; // 다음 노드를 미리 저장
            current.next = prev; // 현재 노드의 다음 포인터를 이전 노드로 설정
            prev = current; // 이전 노드를 현재 노드로 업데이트
            current = next; // 현재 노드를 다음 노드로 이동
        }
        return prev; // 반전된 리스트의 새로운 헤드 반환
    }

    /**
     * 괄호 유효성 검사
     *
     * @param s 검사할 문자열
     * @return 괄호들이 유효한지 여부
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // 열린 괄호를 스택에 넣음
            } else {
                if (stack.isEmpty()) return false; // 스택이 비어있으면 유효하지 않음
                char top = stack.pop(); // 스택에서 열린 괄호를 꺼냄
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // 괄호가 매칭되지 않으면 유효하지 않음
                }
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 모든 괄호가 매칭됨
    }

    /**
     * 해시 테이블을 사용한 두 수의 합 문제
     *
     * @param nums 숫자 배열
     * @param target 목표 값
     * @return 두 수의 인덱스 배열
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 타겟에서 현재 숫자를 뺀 값
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // 두 수의 인덱스 반환
            }
            map.put(nums[i], i); // 현재 숫자와 인덱스를 해시 테이블에 저장
        }
        throw new IllegalArgumentException("해당 조건을 만족하는 두 수가 없습니다.");
    }

    // 연결 리스트 노드 정의
    static class ListNode {
        int val;
        ListNode next;

        // 생성자를 통해 노드 값 초기화
        ListNode(int val) {
            this.val = val;
        }
    }
}