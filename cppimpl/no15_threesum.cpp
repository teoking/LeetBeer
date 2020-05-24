//
// Created by teoking on 2018/7/2.
//

#include <vector>
#include <unordered_map>
#include <iostream>
#include "common.h"

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

std::vector<std::vector<int>> threeSum(std::vector<int>& nums, int target) {
    std::vector<std::vector<int>> vector;

    for (int i = 0; i < nums.size(); ++i) {
        int twoSumTarget = target - nums[i];
        std::vector<int> vec = twoSum2(nums, twoSumTarget);
        if (!vec.empty()) {
            vector.push_back({nums[i], vec[0], vec[1]});
        }
    }

    return vector;
}

int main() {
    std::vector<int> nums = {-1, 0, 1, 2, -1, -4};
    std::vector<std::vector<int>> vectors = threeSum(nums, 0);

    std::cout << "[\n";
    for (int i = 0; i < vectors.size(); ++i) {
        std::cout << "  " << vector2str(vectors[i]) << "\n";
    }
    std::cout << "]" << std::endl;
    return 0;
}
