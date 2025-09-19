# You are given a string s consisting only of the characters '(' and ')'. Your task is to determine the minimum number of parentheses (either '(' or ')') that must be inserted at any positions to make the string s a valid parentheses string.

# A parentheses string is considered valid if:

# Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
# Every closing parenthesis ')' has a corresponding opening parenthesis '('.
#Parentheses are properly nested.

class Solution:
    def minParentheses(self, s):
        # code here
        start=0
        end=0
        
        for ch in s:
            if(ch=='('):
                start+=1
            else :
                if start>0:
                    start-=1
                else:
                    end+=1
                    
        return end+start
    
        
