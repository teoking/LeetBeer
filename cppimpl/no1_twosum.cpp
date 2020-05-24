//
// Created by teoking on 2018/7/2.
//

#include <iostream>
#include <vector>
#include <sstream>
#include <unordered_map>

// Brute-force solution:
// time:  O(n^2)
// space: O(1)
// runtime: 187ms
std::vector<int> twoSum1(std::vector<int> &nums, int target) {
    for (int i = 0; i < nums.size(); ++i) {
        for (int j = i + 1; j < nums.size(); ++j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return {i, j};
            }
        }
    }
    return {};
}

// hashtable solution:
// time:  O(n)
// space: O(n)
// runtime: 9ms
std::vector<int> twoSum2(std::vector<int> &nums, int target) {
    std::unordered_map<int, int> indies;
    for (int i = 0; i < nums.size(); ++i) {
        indies[nums[i]] = i;
    }

    for (int j = 0; j < nums.size(); ++j) {
        int complement = target - nums[j];
        if (indies.count(complement) && indies[complement] != j) {
            return {j, indies[complement]};
        }
    }
    return {};
}

int main() {
    std::vector<int> vector = {2, 7, 11, 15};
    std::vector<int> vec = twoSum1(vector, 9);

    std::ostringstream oss;

    if (!vec.empty()) {
        oss << "[";
        // Convert all but the last element to avoid a trailing ","
        std::copy(vec.begin(), vec.end()-1,
                  std::ostream_iterator<int>(oss, ", "));

        // Now add the last element with no delimiter
        oss << vec.back();

        oss << "]";
    }
    std::cout << oss.str() << std::endl;
    return 0;
}


