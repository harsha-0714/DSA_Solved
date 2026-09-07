class Solution:
    def distinctSubseqII(self, s: str) -> int:
        mod = 10**9 + 7
        freq = [0] * 26
        total_sum = 0
        for c in s:
            total = (1 + total_sum)%mod
            idx = ord(c) - ord('a')
            total_sum = (total_sum + total - freq[idx]) % mod
            freq[idx] = total
        return total_sum