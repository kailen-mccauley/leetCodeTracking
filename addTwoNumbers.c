/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

// Helper function to handle adding to the end of the new linked list
void addNode(struct ListNode** head, int val) {
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val = val;
    newNode->next = NULL;

    if (*head == NULL) {
        *head = newNode;
    } else {
        struct ListNode* temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *curr1 = l1;
    struct ListNode *curr2 = l2;
    struct ListNode *head = NULL;
    int sum = 0;
    int overflow = 0;
    // Iterate accross both linked list and add the current values
    // Max overflow we can have is only a 1 since every node has a max value of 9
    // Keep repeating until we cleared both linked list AND the overflow
    while (curr1 || curr2 || overflow) {
        sum = 0;
        sum += curr1? curr1->val : 0;
        sum += curr2? curr2->val : 0;
        sum += overflow? 1 : 0;
        addNode(&head, sum % 10);
        overflow = sum >= 10? 1:0;
        curr1 = curr1? curr1->next : NULL;
        curr2 = curr2? curr2->next : NULL;
    } 
    return head;
}
